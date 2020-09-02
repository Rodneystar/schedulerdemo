package com.example.quartz.schedulerDemo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private Long id;
    private String agentId;
    private LocalDateTime jobtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
