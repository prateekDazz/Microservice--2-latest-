package com.user.User.MicroService.service;

import com.user.User.MicroService.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);

    User deleteUserByUserId(String userId);
}
