
package com.cognizant.collector.gitlab.beans.projects;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "issues",
    "merge_requests",
    "repo_branches",
    "labels",
    "events",
    "members"
})
@Data
public class Links {

    @JsonProperty("self")
    private String self;
    @JsonProperty("issues")
    private String issues;
    @JsonProperty("merge_requests")
    private String mergeRequests;
    @JsonProperty("repo_branches")
    private String repoBranches;
    @JsonProperty("labels")
    private String labels;
    @JsonProperty("events")
    private String events;
    @JsonProperty("members")
    private String members;
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
