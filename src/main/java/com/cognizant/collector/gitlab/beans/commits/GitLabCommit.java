
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

package com.cognizant.collector.gitlab.beans.commits;

import com.cognizant.collector.gitlab.beans.common.GitLabBaseDetails;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * GitLabCommit
 *
 * @author Cognizant
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "short_id",
        "title",
        "created_at",
        "parent_ids",
        "message",
        "author_name",
        "author_email",
        "authored_date",
        "committer_name",
        "committer_email",
        "committed_date"
})
@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "#{T(com.cognizant.collector.gitlab.component.GitLabCommonUtility).getCollectionName()}")
public class GitLabCommit extends GitLabBaseDetails {

    @JsonProperty("id")
    private String commitId;
    @JsonProperty("short_id")
    private String shortId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;
    @JsonProperty("parent_ids")
    private List<String> parentIds = null;
    @JsonProperty("message")
    private String message;
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("author_email")
    private String authorEmail;
    @JsonProperty("authored_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date authoredDate;
    @JsonProperty("committer_name")
    private String committerName;
    @JsonProperty("committer_email")
    private String committerEmail;
    @JsonProperty("committed_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date committedDate;
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