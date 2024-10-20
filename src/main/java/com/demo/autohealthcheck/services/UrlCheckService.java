package com.demo.autohealthcheck.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.autohealthcheck.models.UatComponent;
import com.demo.autohealthcheck.repos.UrlCheckRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UrlCheckService {
  

     @Autowired
     private UrlCheckRepository urlCheckRepository;

      @Autowired
    private ObjectMapper objectMapper;

     private final RestTemplate restTemplate;

        public UrlCheckService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

     public void checkUrl(UatComponent oneComponent){
        Map<String,Object> infoMap = new HashMap<>();
        String url="http://"+oneComponent.getHostName()+":"+oneComponent.getPort() ;
        System.out.println("-------------start-------------");
        System.out.println("url: "+url);
          try {

            infoMap= this.restTemplate.getForObject(url+ "/actuator/info",Map.class);
            String infoJson = objectMapper.writeValueAsString(infoMap);
               oneComponent.setInfoDetail(infoJson);
               oneComponent.setInfoStatus((String)infoMap.get("status"));
           } catch (Exception e) {
               oneComponent.setInfoDetail(e.getMessage());
              
           }
   
           // Fetch /health
           try {
            infoMap= this.restTemplate.getForObject(url+ "/actuator/health",Map.class);
            
            
               oneComponent.setHealthStatus(infoMap.toString());
           } catch (Exception e) {
               oneComponent.setHealthStatus("DOWN");
           }
           System.out.println("-------------end--------------");
           System.out.println(infoMap.toString());

     }
     @Scheduled(cron = "0 0 * * * *") // Runs every hour
    public void fetchAndSaveActuatorInfo() {
        String url = "http://localhost:8080/actuator/info";
        LocalDateTime currentTime = LocalDateTime.now();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
   
        String infoJson = objectMapper.writeValueAsString(response.toString());
        UatComponent actuatorInfo = new UatComponent();
        actuatorInfo.setInfoDetail(infoJson);
        actuatorInfo.setCheckTime(currentTime);
        urlCheckRepository.save(actuatorInfo);
    }
}
