package com.kapture.springbootcruddemo.service;

import com.kapture.springbootcruddemo.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> fetchUserList();

    User updateUser(User user, Integer id);

    void deleteUserById(Integer id);
}
