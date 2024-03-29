
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

package com.cognizant.collector.gitlab.clients;

import com.cognizant.collector.gitlab.beans.branches.GitLabBranch;
import com.cognizant.collector.gitlab.beans.projects.GitLabProject;
//import com.cognizant.collector.gitlab.beans.commits.GitLabCommit;
//import com.cognizant.collector.gitlab.beans.common.GitLabLabel;
//import com.cognizant.collector.gitlab.beans.common.GitLabMember;
//import com.cognizant.collector.gitlab.beans.events.GitLabEvent;
//import com.cognizant.collector.gitlab.beans.issues.GitLabIssues;
//import com.cognizant.collector.gitlab.beans.merge_requests.GitLabMergeRequest;
import feign.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.List;
import java.util.Map;

/*
 * GitLabClient
 *
 * @author Cognizant
 */
public interface GitLabClient {

    @GetMapping("/api/v4/projects?membership={isMembership}")
    List<GitLabProject> getProjects(@RequestParam("isMembership") boolean isMembership,
                                    @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/repository/branches")
    List<GitLabBranch> getBranches(@PathVariable("projectId") Object projectId,
                                   @RequestHeader HttpHeaders requestHeader);

/*    @GetMapping("/api/v4/projects/{projectId}/repository/commits")
    List<GitLabCommit> getCommits(@PathVariable("projectId") String projectId,
                                  @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/issues")
    List<GitLabIssues> getIssues(@PathVariable("projectId") String projectId,
                                 @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/events")
    List<GitLabEvent> getEvents(@PathVariable("projectId") String projectId,
                                @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/members")
    List<GitLabMember> getMembers(@PathVariable("projectId") String projectId,
                                  @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/labels")
    List<GitLabLabel> getLabels(@PathVariable("projectId") String projectId,
                                @RequestHeader HttpHeaders requestHeader);

    @GetMapping("/api/v4/projects/{projectId}/merge_requests")
    List<GitLabMergeRequest> getMergeRequests(@PathVariable("projectId") String projectId,
                                              @RequestHeader HttpHeaders requestHeader);

*/
    @GetMapping("/api/v4/projects/{projectId}/repository/commits")
    Response getCommits(@PathVariable("projectId") Object projectId,
                        @RequestHeader HttpHeaders requestHeader,
                        @RequestParam Map<String, String> requestParams);

    @GetMapping("/")
    Response getResponse(URI uri, @RequestHeader HttpHeaders requestHeader);
}
