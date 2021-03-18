
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

package com.cognizant.collector.gitlab.beans.projects;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * GitLabProject
 *
 * @author Cognizant
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "description",
    "default_branch",
    "tag_list",
    "ssh_url_to_repo",
    "http_url_to_repo",
    "web_url",
    "name",
    "name_with_namespace",
    "path",
    "path_with_namespace",
    "star_count",
    "forks_count",
    "created_at",
    "last_activity_at",
    "_links",
    "archived",
    "visibility",
    "owner",
    "resolve_outdated_diff_discussions",
    "container_registry_enabled",
    "issues_enabled",
    "merge_requests_enabled",
    "wiki_enabled",
    "jobs_enabled",
    "snippets_enabled",
    "shared_runners_enabled",
    "lfs_enabled",
    "creator_id",
    "namespace",
    "import_status",
    "avatar_url",
    "open_issues_count",
    "public_jobs",
    "ci_config_path",
    "shared_with_groups",
    "only_allow_merge_if_pipeline_succeeds",
    "request_access_enabled",
    "only_allow_merge_if_all_discussions_are_resolved",
    "printing_merge_request_link_enabled",
    "permissions"
})
@Data
public class GitLabProject {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("tag_list")
    private List<Object> tagList = null;
    @JsonProperty("ssh_url_to_repo")
    private String sshUrlToRepo;
    @JsonProperty("http_url_to_repo")
    private String httpUrlToRepo;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("name")
    private String name;
    @JsonProperty("name_with_namespace")
    private String nameWithNamespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("path_with_namespace")
    private String pathWithNamespace;
    @JsonProperty("star_count")
    private Integer starCount;
    @JsonProperty("forks_count")
    private Integer forksCount;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("last_activity_at")
    private String lastActivityAt;
    @JsonProperty("_links")
    private Links links;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("resolve_outdated_diff_discussions")
    private Boolean resolveOutdatedDiffDiscussions;
    @JsonProperty("container_registry_enabled")
    private Boolean containerRegistryEnabled;
    @JsonProperty("issues_enabled")
    private Boolean issuesEnabled;
    @JsonProperty("merge_requests_enabled")
    private Boolean mergeRequestsEnabled;
    @JsonProperty("wiki_enabled")
    private Boolean wikiEnabled;
    @JsonProperty("jobs_enabled")
    private Boolean jobsEnabled;
    @JsonProperty("snippets_enabled")
    private Boolean snippetsEnabled;
    @JsonProperty("shared_runners_enabled")
    private Boolean sharedRunnersEnabled;
    @JsonProperty("lfs_enabled")
    private Boolean lfsEnabled;
    @JsonProperty("creator_id")
    private Integer creatorId;
    @JsonProperty("namespace")
    private Namespace namespace;
    @JsonProperty("import_status")
    private String importStatus;
    @JsonProperty("avatar_url")
    private Object avatarUrl;
    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;
    @JsonProperty("public_jobs")
    private Boolean publicJobs;
    @JsonProperty("ci_config_path")
    private Object ciConfigPath;
    @JsonProperty("shared_with_groups")
    private List<Object> sharedWithGroups = null;
    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    private Boolean onlyAllowMergeIfPipelineSucceeds;
    @JsonProperty("request_access_enabled")
    private Boolean requestAccessEnabled;
    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    private Boolean onlyAllowMergeIfAllDiscussionsAreResolved;
    @JsonProperty("printing_merge_request_link_enabled")
    private Boolean printingMergeRequestLinkEnabled;
    @JsonProperty("permissions")
    private Permissions permissions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
