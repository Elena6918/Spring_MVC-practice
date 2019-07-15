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
        this.jdbcTemplate.update("INSERT INTO Spring_userWork (work_content, create_time) VALUES(?,?)",
                userWork.getWorkContent(), userWork.getCreationTime());
    }

    public UserWork findWorkByWorkId(final int workId) {
        String sqlStr = " SELECT work_id, work_content " + " FROM Spring_userWork WHERE work_id =? ";
        final UserWork userWork = new UserWork();
        jdbcTemplate.query(sqlStr, new Object[]{workId},
                rs -> {
                    userWork.setWorkContent(rs.getString("work_content"));
                    userWork.setWorkId(workId);
                });
        return userWork;
    }
}
