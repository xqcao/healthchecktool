package com.demo.autohealthcheck.models;

public class UatComponent {
     private String appName;
     private String infoDetails;

     public UatComponent(String appName, String infoDetails, String healthStatus, String infoStatus) {
          this.appName = appName;
          this.infoDetails = infoDetails;
          this.healthStatus = healthStatus;
          this.infoStatus = infoStatus;
     }
     private String healthStatus;
     private String infoStatus;
     public UatComponent() {
     }
     public String getAppName() {
          return appName;
     }
     public void setAppName(String appName) {
          this.appName = appName;
     }
     public String getInfoDetails() {
          return infoDetails;
     }
     public void setInfoDetails(String infoDetails) {
          this.infoDetails = infoDetails;
     }
     public String getHealthStatus() {
          return healthStatus;
     }
     public void setHealthStatus(String healthStatus) {
          this.healthStatus = healthStatus;
     }
     public String getInfoStatus() {
          return infoStatus;
     }
     public void setInfoStatus(String infoStatus) {
          this.infoStatus = infoStatus;
     }
     
}
