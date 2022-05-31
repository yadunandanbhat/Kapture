package com.kapture.springbootcruddemo.service;

import com.kapture.springbootcruddemo.entity.User;
import com.kapture.springbootcruddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override public List<User> fetchUserList() {
        return (List<User>) userRepository.findAll();
    }

    @Override public User updateUser(User user, Integer id) {
        User userDB
            = userRepository.findById(id).get();

        if (Objects.nonNull(user.getName())
            && !"".equalsIgnoreCase(
            user.getName())) {
            userDB.setName(
                user.getName());
        }

        if (Objects.nonNull(
            user.getEmail())
            && !"".equalsIgnoreCase(
            user.getEmail())) {
            userDB.setEmail(
                user.getEmail());
        }

        if (Objects.nonNull(user.getPassword())
            && !"".equalsIgnoreCase(
            user.getPassword())) {
            userDB.setPassword(
                user.getPassword());
        }

        return userRepository.save(userDB);
    }

    @Override public void deleteUserById(Integer id) {
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.deleteById(id);
    }
}
