package com.demo.autohealthcheck.contollers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.autohealthcheck.models.UatComponent;
import com.demo.autohealthcheck.repos.UrlCheckRepository;
import com.demo.autohealthcheck.services.UrlCheckService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyController {

    @Autowired
     private UrlCheckRepository urlCheckRepository;

      @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UrlCheckService urlCheckService;

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "Pong";
    }
    
    @GetMapping("/local")
    public String getOneUrlString(Model model) {
        UatComponent one = new UatComponent();
        one.setHostName("localhost");
        one.setPort("8080");
        urlCheckService.checkUrl(one);
        System.out.println(one);
        one.setCheckTime(LocalDateTime.now());
        one.setTimestamp(LocalDateTime.now());
    
        urlCheckRepository.save(one);
        model.addAttribute("oneComponent",one);
        return "success";
    }

    @GetMapping("/main")
    public String main(){
        return "mainpage";
    }

   
    @GetMapping("/timestamps")
    @ResponseBody
    public List<LocalDateTime> getAllTimestamps() {

        return urlCheckRepository.findDistinctTimestamp();

    }

    @GetMapping("/actuatorInfo/{timestamp}")
    @ResponseBody
    public UatComponent getActuatorInfoByTimestamp(@PathVariable String timestamp) {

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        // LocalDateTime selectedTimestamp = LocalDateTime.parse(timestamp, formatter);
        LocalDateTime selectedTimestamp = LocalDateTime.parse(timestamp);
        return urlCheckRepository.findByTimestamp(selectedTimestamp);
    }
}
