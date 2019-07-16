package com.skill.service;

import com.skill.domain.User;
import com.skill.domain.UserWork;


public interface UserService {
    boolean hasMatchUser(String userName, String password);

    User findUserByUserName(String userName);

    void loginSuccess(User user);

    void insert(User newUser);

    UserWork findWorkByWorkName(String workName);

    void saveUserWork(UserWork userWork);
}