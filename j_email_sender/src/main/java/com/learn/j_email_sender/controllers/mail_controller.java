package com.learn.j_email_sender.controllers;

import com.learn.j_email_sender.DTO.EmailRequest;
import com.learn.j_email_sender.service.email_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class mail_controller {

    @Autowired
    private email_service Email_Service;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest){
        try {
            // Use the email text sent in the request
            Email_Service.sendSimpleEmail("playerp043@gmail.com", "Response from client ", emailRequest.getText());
            return "Email sent successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }


    @GetMapping("/test")
    public String test(){
        return "Controller created test working this is a testing Api";
    }
}
