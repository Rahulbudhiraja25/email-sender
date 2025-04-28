package com.learn.j_email_sender.controllers;

import com.learn.j_email_sender.DTO.EmailRequest;
import com.learn.j_email_sender.service.email_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class mail_controller {

    @Autowired
    private email_service Email_Service;

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // Use the email text sent in the request
            Email_Service.sendSimpleEmail("playerp043@gmail.com", "Response from client "+emailRequest.getName(), emailRequest.getText());
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Mail sent successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "failure");
            response.put("message", "Some error occured" + e.getMessage());
        return ResponseEntity.ok(response);
        }
    }




    @GetMapping("/test")
    public String test(){
        return "Controller created test working this is a testing Api";
    }
}
