package com.hilab.hilabcrud.repository;

import com.hilab.hilabcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("mongoDB")
public class UserRepositoryImplMongoDB implements UserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> findUser(Map<String, String> params) {
        if (params.isEmpty()) {
            return mongoTemplate.findAll(User.class);
        }
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        params.forEach((k, v) -> criteria.add(Criteria.where((k)).is(v)));

        query.addCriteria(
                new Criteria()
                        .andOperator(criteria.stream().toArray(Criteria[]::new)));

        return mongoTemplate.find(query, User.class);
    }

    @Override
    public User findByEmail(String email) {
        return mongoTemplate.findOne(new Query(Criteria.where("email").is(email)), User.class);
    }
    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public User update(User user) throws IOException {
        return this.save(user);
    }
}
