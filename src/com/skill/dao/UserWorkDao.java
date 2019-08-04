package com.skill.dao;

import com.skill.domain.UserWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("userWorkDao")
public class UserWorkDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserWorkDao() { }

    public void insert(UserWork userWork) {
        this.jdbcTemplate.update("INSERT INTO Spring_userWork (work_title, work_content, create_time, " +
                        "image_path, user_name) VALUES(?,?,?,?,?)",
                userWork.getWorkName(), userWork.getWorkContent(), userWork.getCreationTime(),
                userWork.getImagePath(), userWork.getUserName());
    }

    public void delete(int workId){
        this.jdbcTemplate.update("DELETE FROM Spring_userWork WHERE work_id = ?", workId);
    }
    public UserWork findWorkByWorkId(final int workId) {
        String sqlStr = " SELECT work_title, work_content, create_time, image_path, user_name " + " FROM Spring_userWork WHERE work_id =? ";
        final UserWork userWork = new UserWork();
        jdbcTemplate.query(sqlStr, new Object[]{workId},
                rs -> {
                    userWork.setWorkContent(rs.getString("work_content").replace("\r\n","<br>"));
                    userWork.setWorkName(rs.getString("work_title"));
                    userWork.setWorkId(workId);
                    userWork.setCreationTime(rs.getDate("create_time"));
                    userWork.setImagePath(rs.getString("image_path"));
                    userWork.setUserName(rs.getString("user_name"));
                });
        return userWork;
    }
    public List<UserWork> workList(String userName){
        String sqlStr="SELECT * FROM Spring_userWork WHERE user_name = "+ "\"" + userName + "\"";
        List<Map<String, Object>> workList = jdbcTemplate.queryForList(sqlStr);
        return UserWork.toObject(workList);
    }
}
