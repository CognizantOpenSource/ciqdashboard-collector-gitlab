
package com.cognizant.leap.data.collector.gitlab.beans.branches;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "commit",
    "merged",
    "protected",
    "developers_can_push",
    "developers_can_merge"
})
@Data
public class GitLabBranch {

    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit commit;
    @JsonProperty("merged")
    private Boolean merged;
    @JsonProperty("protected")
    private Boolean isProtected;
    @JsonProperty("developers_can_push")
    private Boolean developersCanPush;
    @JsonProperty("developers_can_merge")
    private Boolean developersCanMerge;
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
