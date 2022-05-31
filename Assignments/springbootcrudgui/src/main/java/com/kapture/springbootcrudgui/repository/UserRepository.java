package com.kapture.springbootcrudgui.repository;

import com.kapture.springbootcrudgui.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}