//Commented to fix SAST issue. Reffered to Future Implementation

/*package com.cognizant.collector.gitlab.beans.events;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "commit_count",
    "action",
    "ref_type",
    "commit_from",
    "commit_to",
    "ref",
    "commit_title"
})
@Data
public class PushData {

    @JsonProperty("commit_count")
    private Integer commitCount;
    @JsonProperty("action")
    private String action;
    @JsonProperty("ref_type")
    private String refType;
    @JsonProperty("commit_from")
    private String commitFrom;
    @JsonProperty("commit_to")
    private String commitTo;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("commit_title")
    private String commitTitle;
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