package com.demo.autohealthcheck.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="UAT_COMPONENT")
public class UatComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime checkTime;
     private String port;
    private String name;
    private String hostName;
    private String activeStatus;
    private String env;

    @Column(columnDefinition = "TEXT")
    private String infoDetail;
    
    private String infoStatus;
    private String healthStatus;
    private LocalDateTime timestamp;
    





    public Long getId() {
        return id;
    }






    public void setId(Long id) {
        this.id = id;
    }






    public LocalDateTime getCheckTime() {
        return checkTime;
    }






    public void setCheckTime(LocalDateTime checkTime) {
        this.checkTime = checkTime;
    }






    public String getPort() {
        return port;
    }






    public void setPort(String port) {
        this.port = port;
    }






    public String getName() {
        return name;
    }






    public void setName(String name) {
        this.name = name;
    }






    public String getHostName() {
        return hostName;
    }






    public void setHostName(String hostName) {
        this.hostName = hostName;
    }






    public String getActiveStatus() {
        return activeStatus;
    }






    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }






    public String getEnv() {
        return env;
    }






    public void setEnv(String env) {
        this.env = env;
    }






    public String getInfoDetail() {
        return infoDetail;
    }






    public void setInfoDetail(String infoDetail) {
        this.infoDetail = infoDetail;
    }






    public String getInfoStatus() {
        return infoStatus;
    }






    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }






    public String getHealthStatus() {
        return healthStatus;
    }






    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }






    public LocalDateTime getTimestamp() {
        return timestamp;
    }






    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }






    @Override
    public String toString() {
        return "UatComponent [id:" + id + ", checkTime:" + checkTime + ", port:" + port + ", name:" + name
                + ", hostName:" + hostName + ", activeStatus:" + activeStatus + ", env:" + env + ", infoDetail:"
                + infoDetail + ", infoStatus:" + infoStatus + ", healthStatus:" + healthStatus + ", timestamp:"
                + timestamp + ", getId():" + getId() + ", getCheckTime():" + getCheckTime() + ", getPort():" + getPort()
                + ", getName():" + getName() + ", getHostName():" + getHostName() + ", getActiveStatus():"
                + getActiveStatus() + ", getEnv():" + getEnv() + ", getInfoDetail():" + getInfoDetail()
                + ", getInfoStatus():" + getInfoStatus() + ", getHealthStatus():" + getHealthStatus()
                + ", getTimestamp():" + getTimestamp() + ", getClass():" + getClass() + ", hashCode():" + hashCode()
                + ", toString():" + super.toString() + "]";
    }




    
}
