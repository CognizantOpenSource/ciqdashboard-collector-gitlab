package com.cognizant.collector.gitlab.beans.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.Instant;
import java.util.Date;

/**
 * Created by 784420 on 10/14/2019 7:21 PM
 */
@Data
public class GitLabBaseDetails {
    @Id
    private String id;
    private Integer projectId;
    private String projectName;
    private String projectWebUrl;
    private String branchName;

    /* User Auditing fields*/
    @JsonIgnore
    @CreatedBy
    private String createdUser;
    @JsonIgnore
    @CreatedDate
    private Date createdDate;
    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedUser;
    @JsonIgnore
    @LastModifiedDate
    private Instant lastModifiedDate;
}
