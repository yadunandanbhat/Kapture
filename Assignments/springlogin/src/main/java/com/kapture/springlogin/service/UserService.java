package com.kapture.springlogin.service;

import com.kapture.springlogin.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
