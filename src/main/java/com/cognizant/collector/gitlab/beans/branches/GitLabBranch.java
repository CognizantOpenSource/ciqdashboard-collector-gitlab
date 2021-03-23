
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

package com.cognizant.collector.gitlab.beans.branches;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/*
 * GitLabBranch
 *
 * @author Cognizant
 */

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
