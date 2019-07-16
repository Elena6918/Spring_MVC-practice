package com.skill.domain;
import java.util.Date;

public class UserWork {
    private int workId;
    private String workContent;
    private Date creationTime;
    private String workName;
    public UserWork(){};

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
}
