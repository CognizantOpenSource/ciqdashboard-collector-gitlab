
package com.cognizant.collector.gitlab.beans.events;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "project_id",
    "action_name",
    "target_id",
    "target_iid",
    "target_type",
    "author_id",
    "target_title",
    "created_at",
    "author",
    "push_data",
    "author_username"
})
@Data
public class GitLabEvent {

    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("action_name")
    private String actionName;
    @JsonProperty("target_id")
    private Object targetId;
    @JsonProperty("target_iid")
    private Object targetIid;
    @JsonProperty("target_type")
    private Object targetType;
    @JsonProperty("author_id")
    private Integer authorId;
    @JsonProperty("target_title")
    private Object targetTitle;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("push_data")
    private PushData pushData;
    @JsonProperty("author_username")
    private String authorUsername;
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
