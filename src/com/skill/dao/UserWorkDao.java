package com.skill.dao;

import com.skill.domain.UserWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository("userWorkDao")
public class UserWorkDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserWorkDao() {
        System.out.println("UserWorkDao");
    }

    public void insert(UserWork userWork) {
        this.jdbcTemplate.update("INSERT INTO Spring_userWork (work_title, work_content, create_time) VALUES(?,?,?)",
                userWork.getWorkName(), userWork.getWorkContent(), userWork.getCreationTime());
    }

    public UserWork findWorkByWorkName(final String workTitle) {
        String sqlStr = " SELECT work_id, work_content " + " FROM Spring_userWork WHERE work_title =? ";
        final UserWork userWork = new UserWork();
        jdbcTemplate.query(sqlStr, new Object[]{workTitle},
                rs -> {
                    userWork.setWorkContent(rs.getString("work_content"));
                    userWork.setWorkName(workTitle);
                    userWork.setWorkId(rs.getInt("work_id"));
                });
        return userWork;
    }
}
