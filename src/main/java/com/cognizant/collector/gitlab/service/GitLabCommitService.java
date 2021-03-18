
/*
 * © [2021] Cognizant. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http:www.apache.orglicensesLICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.cognizant.collector.gitlab.service;

import com.cognizant.collector.gitlab.beans.commits.GitLabCommit;
import com.cognizant.collector.gitlab.db.repo.GitLabCustomCommitRepository;
import com.cognizant.collector.gitlab.db.GitLabCommitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/*
 * GitLabCommitService
 *
 * @author Cognizant
 */
@Service
@Slf4j
@AllArgsConstructor
public class GitLabCommitService {

    private GitLabCommitRepository repository;
    private GitLabCustomCommitRepository customCommitRepository;


    /**
     * Store commit details in the Database
     *
     * @param commit commit details
     * @return return commit details post storing in DB
     */
//    public GitLabCommit saveCommit(GitLabCommit commit) {
//        return repository.save(commit);
//    }

    /**
     * Store List of commit details in the Database
     *
     * @param commits list of commit details
     * @return return list of commit details post storing in DB
     */
    public List<GitLabCommit> saveAllCommits(List<GitLabCommit> commits) {
        return repository.saveAll(commits);
    }

    /**
     * getting all commit details which are available in the DB
     *
     * @return list of commits
     */
//    public List<GitLabCommit> getAll() {
//        return repository.findAll();
//    }

    /**
     * Remove all documents from the collection
     */
//    public void deleteAllCommits() {
//        repository.deleteAll();
//    }

    public String getLastCommitDate(Object projectNameOrId){
        String since = "";
        List<GitLabCommit> lastCommittedDateQuery = customCommitRepository.findLastCommittedDateQuery(projectNameOrId);
        if (!CollectionUtils.isEmpty(lastCommittedDateQuery)) {
            since = lastCommittedDateQuery.get(0).getCommittedDate().toInstant().toString();
        }
        log.info("Since Date is: {}", since);
        return since;
    }
}
