package com.hilab.hilabcrud.repository;

import com.hilab.hilabcrud.model.User;
import java.util.List;
import java.util.Map;

public interface UserRepository {

    List<User> findUser(Map<String, String> params) throws Exception;

    User findByEmail(String email) throws Exception;

    User update(User user) throws Exception;

    User save(User user) throws Exception;

}

