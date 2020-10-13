package com.cognizant.leap.data.collector.gitlab.component;

import com.cognizant.leap.data.collector.gitlab.beans.branches.GitLabBranch;
import com.cognizant.leap.data.collector.gitlab.beans.commits.GitLabCommit;
import com.cognizant.leap.data.collector.gitlab.beans.projects.GitLabProject;
import com.cognizant.leap.data.collector.gitlab.clients.GitLabClient;
import com.cognizant.leap.data.collector.gitlab.constants.Constants;
import com.cognizant.leap.data.collector.gitlab.service.GitLabCommitService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * Created by 784420 on 10/11/2019 3:36 PM
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GitLabComponent {

    private final GitLabClient client;
    private final GitLabCommonUtility commonUtility;
    private final GitLabCommitService service;

    private ObjectMapper objectMapper = new ObjectMapper();
    private HttpHeaders requestHeader = new HttpHeaders();

    @Value("${gitlab.url}")
    private String gitLabUrl;
    @Value("${gitlab.token}")
    private String token;

    @PostConstruct
    private void postConstructMethod() {
        requestHeader = commonUtility.getHeaders();
        updateCommits();
    }

    /**
     * Getting all membership project details for the user
     *
     * @return list of project details
     */
    public List<GitLabProject> getProjects() {
        return client.getProjects(true, requestHeader);
    }


    /**
     * Getting all branches for the project
     *
     * @param projectNameOrId name or id of the project to fetch the branches details
     * @return list of branches
     */
    public List<GitLabBranch> getBranches(Object projectNameOrId) {
        return client.getBranches(projectNameOrId, requestHeader);
    }


    /**
     * getting commits for the all projects which are having access to the user
     *
     * @return all commits count based on the project
     */
    public void updateCommits() {
        log.info("Getting Project details ");
        List<GitLabProject> projects = getProjects();
        for (GitLabProject project : projects) {
            log.info("Project id: {}, Name: {}", project.getId(), project.getName());
            updateProjectCommits(project.getId(), project.getName(), project.getWebUrl());
        }
        log.info("Projects: " + projects);
    }

    /**
     * getting commit details based on {@code projectNameOrId}
     *
     * @param projectNameOrId name or id of the project
     * @param projectName     name the project
     * @param projectWebUrl   project web url
     */
    private void updateProjectCommits(Object projectNameOrId, String projectName, String projectWebUrl) {
        List<GitLabBranch> branches = getBranches(projectNameOrId);
        String since = service.getLastCommitDate(projectNameOrId);
        for (GitLabBranch branch : branches) {
            log.info("Project ( id: {}, Name: {} ), Branch Name: {}", projectNameOrId, projectName, branch.getName());
            updateProjectBranchCommits(projectNameOrId, projectName, branch.getName(), projectWebUrl, since);
        }
    }

    /**
     * Getting branch wise commit details
     *
     * @param projectNameOrId name or id of the project
     * @param projectName     project name
     * @param branchName      branch name
     * @param projectWebUrl   project web url
     * @param since           since date to fetch commits from server
     */
    private void updateProjectBranchCommits(Object projectNameOrId, String projectName, String branchName, String projectWebUrl, String since) {
        List<GitLabCommit> commits = null;
        int commitCount = 0;
        boolean hasMorePages = true;
        int nextPage = 1;
        while (hasMorePages) {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, GitLabCommit.class);
            ResponseEntity<List<GitLabCommit>> response;
            try {
                response = commonUtility.getCommitResponse(type, projectNameOrId, branchName, Constants.RESULTS_PER_PAGE, nextPage, since);
                log.info("page " + nextPage + ": " + response.getStatusCode());
                commits = response.getBody();
                commits = saveAllCommitsInDB(projectNameOrId, projectName, branchName, projectWebUrl, commits);
            } catch (IOException e) {
                log.error(e.getLocalizedMessage(), e);
            }
            if (commits == null || commits.size() < Constants.RESULTS_PER_PAGE) {
                hasMorePages = false;
                continue;
            }
            nextPage++;
            commitCount += commits.size();
        }
        log.info("Commits: " + commitCount);
    }

    /**
     * Storing commit details in the DataBase
     *
     * @param projectNameOrId name or id of the project
     * @param projectName     project name
     * @param branchName      branch name
     * @param projectWebUrl   project web url
     * @param commits         list of commit for all membership projects
     * @return return the list of commits post storing in DB
     */
    private List<GitLabCommit> saveAllCommitsInDB(Object projectNameOrId, String projectName, String branchName, String projectWebUrl, List<GitLabCommit> commits) {
        commits.forEach(commit -> {
            if (projectNameOrId instanceof Integer)
                commit.setProjectId((Integer) projectNameOrId);
            commit.setProjectName(projectName);
            commit.setProjectWebUrl(projectWebUrl);
            commit.setBranchName(branchName);
        });
        return service.saveAllCommits(commits);
    }
}
