//Commented to fix SAST issue. Reffered to Future Implementation

/*package com.cognizant.collector.gitlab.beans.merge_requests;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "iid",
    "project_id",
    "title",
    "description",
    "state",
    "created_at",
    "updated_at",
    "target_branch",
    "source_branch",
    "upvotes",
    "downvotes",
    "author",
    "assignee",
    "source_project_id",
    "target_project_id",
    "labels",
    "work_in_progress",
    "milestone",
    "merge_when_pipeline_succeeds",
    "merge_status",
    "sha",
    "merge_commit_sha",
    "user_notes_count",
    "should_remove_source_branch",
    "force_remove_source_branch",
    "web_url",
    "time_stats"
})
@Data
public class GitLabMergeRequest {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("iid")
    private Integer iid;
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("state")
    private String state;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("target_branch")
    private String targetBranch;
    @JsonProperty("source_branch")
    private String sourceBranch;
    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("assignee")
    private Assignee assignee;
    @JsonProperty("source_project_id")
    private Integer sourceProjectId;
    @JsonProperty("target_project_id")
    private Integer targetProjectId;
    @JsonProperty("labels")
    private List<Object> labels = null;
    @JsonProperty("work_in_progress")
    private Boolean workInProgress;
    @JsonProperty("milestone")
    private Object milestone;
    @JsonProperty("merge_when_pipeline_succeeds")
    private Boolean mergeWhenPipelineSucceeds;
    @JsonProperty("merge_status")
    private String mergeStatus;
    @JsonProperty("sha")
    private String sha;
    @JsonProperty("merge_commit_sha")
    private Object mergeCommitSha;
    @JsonProperty("user_notes_count")
    private Integer userNotesCount;
    @JsonProperty("should_remove_source_branch")
    private Object shouldRemoveSourceBranch;
    @JsonProperty("force_remove_source_branch")
    private Boolean forceRemoveSourceBranch;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("time_stats")
    private TimeStats timeStats;
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
*/