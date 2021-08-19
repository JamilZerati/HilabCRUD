package com.hilab.hilabcrud.service;

import com.hilab.hilabcrud.model.User;
import com.hilab.hilabcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final List<String> validParams = Arrays.asList("firstName", "surName", "birthDate", "email", "job");

    private UserRepository userRepository;

    @Autowired // inject FirstServiceImpl
    public UserService(@Qualifier("mongoDB") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) throws Exception {
        User userSearch = userRepository.findByEmail(user.getEmail());
        if (userSearch == null) this.userRepository.save(user);
    }

    public List<User> findUser(Map<String, String> params) throws Exception {
        for (String parameter: params.keySet()){
            if (!validParams.contains(parameter)) throw new Exception("Invalid Parameter.");
        }

        return userRepository.findUser(params);
    }

    public void update(User user) throws Exception {
        User userSaved = userRepository.findByEmail(user.getEmail());
        if (userSaved == null) {
            throw new Exception("User not found.");
        }
        user.setId(userSaved.getId());
        userRepository.update(user);
    }
}