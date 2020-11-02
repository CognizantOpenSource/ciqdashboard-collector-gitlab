package com.cognizant.collector.gitlab.db.impl;

import com.cognizant.collector.gitlab.beans.commits.GitLabCommit;
import com.cognizant.collector.gitlab.db.repo.GitLabCustomCommitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 784420 on 10/16/2019 6:16 PM
 */
@Repository
public class GitLabCustomCommitRepositoryImpl implements GitLabCustomCommitRepository {

    private MongoTemplate template;
    @Autowired
    public GitLabCustomCommitRepositoryImpl(MongoTemplate mongoTemplate) {
        this.template = mongoTemplate;
    }

    @Override
    public List<GitLabCommit> findLastCommittedDateQuery(Object projectNameOrId) {
        return findByFieldInOrder(projectNameOrId, Sort.Direction.DESC, "committedDate");
    }

    private List<GitLabCommit> findByFieldInOrder(Object projectNameOrId, Sort.Direction direction, String fieldName){
        Query query = new Query();
        Criteria criteria;
        if (projectNameOrId instanceof Integer)
            criteria = Criteria.where("projectId").is((Integer)projectNameOrId);
        else
            criteria = Criteria.where("projectId").is(projectNameOrId).orOperator(Criteria.where("projectName").is(projectNameOrId));

        query.addCriteria(criteria)
                .with(Sort.by(new Sort.Order(direction, fieldName)));
        return template.find(query, GitLabCommit.class);
    }
}
