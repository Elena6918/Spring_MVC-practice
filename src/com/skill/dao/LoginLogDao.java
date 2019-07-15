package com.skill.dao;

import com.skill.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("loginLogDao")
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "INSERT INTO login_log(user_id,ip,login_datetime) " + "VALUES(?,?,?)";
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sqlStr, args);
    }
}