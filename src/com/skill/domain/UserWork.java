package com.skill.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserWork {
    private int workId;
    private String workContent;
    private Date creationTime;
    private String workName;
    private String imagePath;

    public UserWork(){}

    public int getWorkId(){
        return workId;
    }
    public void setWorkId(int workId) {
        this.workId = workId;
    }
    public String getWorkContent(){
        return workContent;
    }
    public void setWorkContent(String workContent){
        this.workContent = workContent;
    }
    public Date getCreationTime(){
        return creationTime;
    }
    public void setCreationTime(Date creationTime){
        this.creationTime = creationTime;
    }

    public String getWorkName(){
        return workName;
    }
    public void setWorkName(String workName){
        this.workName = workName;
    }

    public String getImagePath(){
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    private static UserWork toObject(Map<String, Object> map) {
        UserWork userWork = new UserWork();
        userWork.setWorkName((String)map.get("work_title"));
        userWork.setWorkContent((String)map.get("work_content"));
        userWork.setCreationTime((Date)map.get("create_time"));
        userWork.setWorkId((Integer)map.get("work_id"));
        return userWork;
    }

    public static List<UserWork> toObject(List<Map<String, Object>> lists){
        List<UserWork> userWorks = new ArrayList<UserWork>();
        for (Map<String, Object> map : lists) {
            UserWork userWork =  UserWork.toObject(map);
            if (userWork != null) {
                userWorks.add(userWork);
            }
        }
        return userWorks;
    }
}
