package com.cognizant.leap.data.collector.gitlab.db;

import com.cognizant.leap.data.collector.gitlab.beans.commits.GitLabCommit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by 784420 on 10/14/2019 7:50 PM
 */
public interface GitLabCommitRepository extends MongoRepository<GitLabCommit, String> {
}
