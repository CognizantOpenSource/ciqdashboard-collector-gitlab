
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

/*
 * GitLabCustomCommitRepositoryImpl
 *
 * @author Cognizant
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
