package com.skill.dao;

import com.skill.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDao() {
        System.out.println("UserDao");
    }

    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(*) from Spring_user where user_name = ? and password = ?";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = " SELECT user_id,user_name,credits " + " FROM Spring_user WHERE user_name =? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName},
                rs -> {
                    user.setUserId(rs.getInt("user_id"));
                    user.setUserName(userName);
                    user.setCredits(rs.getInt("credits"));
                });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = " UPDATE Spring_user SET last_visit=?,last_ip=?,credits=? "
                + " WHERE user_id =?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),
                user.getLastIp(), user.getCredits(), user.getUserId()});
    }

    public void insert(User user) {
        this.jdbcTemplate.update("INSERT INTO Spring_user(user_name,password) VALUES(?,?)",
                user.getUserName(), user.getPassword());
    }

    public void delete(int id) {
        this.jdbcTemplate.update("DELETE FROM Spring_user WHERE id=?", id);
    }
}