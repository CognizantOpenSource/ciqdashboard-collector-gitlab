package com.cognizant.leap.data.collector.gitlab.db.repo;

import com.cognizant.leap.data.collector.gitlab.beans.commits.GitLabCommit;

import java.util.List;

/**
 * Created by 784420 on 10/16/2019 6:09 PM
 */
public interface GitLabCustomCommitRepository {
    List<GitLabCommit> findLastCommittedDateQuery(Object projectNameOrId);
}
