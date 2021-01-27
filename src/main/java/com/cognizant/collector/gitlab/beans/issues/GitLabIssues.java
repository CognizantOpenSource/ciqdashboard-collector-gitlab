//Commented to fix SAST issue. Reffered to Future Implementation

/*package com.cognizant.collector.gitlab.beans.issues;

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
    "labels",
    "milestone",
    "assignees",
    "author",
    "assignee",
    "user_notes_count",
    "upvotes",
    "downvotes",
    "due_date",
    "confidential",
    "web_url",
    "time_stats"
})
@Data
public class GitLabIssues {

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
    @JsonProperty("labels")
    private List<String> labels = null;
    @JsonProperty("milestone")
    private Milestone milestone;
    @JsonProperty("assignees")
    private List<Assignee> assignees = null;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("assignee")
    private Assignee assignee;
    @JsonProperty("user_notes_count")
    private Integer userNotesCount;
    @JsonProperty("upvotes")
    private Integer upvotes;
    @JsonProperty("downvotes")
    private Integer downvotes;
    @JsonProperty("due_date")
    private Object dueDate;
    @JsonProperty("confidential")
    private Boolean confidential;
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