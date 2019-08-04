package com.skill.service.impl;

import com.skill.dao.LoginLogDao;
import com.skill.dao.UserDao;
import com.skill.dao.UserWorkDao;
import com.skill.domain.LoginLog;
import com.skill.domain.User;
import com.skill.domain.UserWork;
import com.skill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;
    @Autowired
    private UserWorkDao userWorkDao;

    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

    public void insert(User user) {
        userDao.insert(user);
    }


    public UserWork findWorkById(int workId){
        return userWorkDao.findWorkByWorkId(workId);
    }

    public void saveUserWork(UserWork userWork){
        userWorkDao.insert(userWork);
    }

    public void deleteUserWork(int workId){
        userWorkDao.delete(workId);
    }

    public List<UserWork> workList(String userName){
        return userWorkDao.workList(userName);
    }
}
