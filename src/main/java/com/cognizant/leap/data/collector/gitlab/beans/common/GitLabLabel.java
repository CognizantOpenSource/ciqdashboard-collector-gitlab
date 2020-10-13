package com.cognizant.leap.data.collector.gitlab.beans.common;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"color",
"description",
"open_issues_count",
"closed_issues_count",
"open_merge_requests_count",
"priority",
"subscribed"
})
@Data
public class GitLabLabel {

@JsonProperty("id")
private Integer id;
@JsonProperty("name")
private String name;
@JsonProperty("color")
private String color;
@JsonProperty("description")
private String description;
@JsonProperty("open_issues_count")
private Integer openIssuesCount;
@JsonProperty("closed_issues_count")
private Integer closedIssuesCount;
@JsonProperty("open_merge_requests_count")
private Integer openMergeRequestsCount;
@JsonProperty("priority")
private Object priority;
@JsonProperty("subscribed")
private Boolean subscribed;
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