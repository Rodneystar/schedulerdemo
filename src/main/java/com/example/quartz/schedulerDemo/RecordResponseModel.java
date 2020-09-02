package com.example.quartz.schedulerDemo;

import java.time.LocalDateTime;

public class RecordResponseModel {

    private String agentId;
    private LocalDateTime jobtime;

    public RecordResponseModel(RecordEntity entity) {
        this.agentId = entity.getAgentId();
        this.jobtime = entity.getJobtime();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public LocalDateTime getJobtime() {
        return jobtime;
    }

    public void setJobtime(LocalDateTime jobtime) {
        this.jobtime = jobtime;
    }
}
