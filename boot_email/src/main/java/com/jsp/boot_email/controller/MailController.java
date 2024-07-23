package com.jsp.boot_email.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.Emails;
import com.jsp.boot_email.service.EmailService;

@RestController
public class MailController {
	@GetMapping("/msg")
	public String msg() {
		return "hi";
		
	}
	
//    @PostMapping("/send")
//	public void sendMsg(@RequestBody Email email) {
//		System.out.println(email);
//		
//	}
    
    @Autowired
    EmailService service;
    @PostMapping("/send")
    public String sendMsg(@RequestBody Email email) {
    	try {
    		service.sendMsg(email);
    		return "msg send sucessfully";
    		
    	}
    	catch(Exception e) {
    		return "internal issuse try again";
    	}
    }
    @PostMapping("/sends")
    public String sendMulMsgs(@RequestBody Emails emails) {
    	try {
			service.sendMulMsgs(emails);
			return "msg send sucessfully";
		} catch (Exception e) {
			return "internal issuse try again"; 
		}
    	
    	
    }
    @PostMapping("/send3")
    public String sendHtml(@RequestBody Email email) {
    	try {
    		service.sendHtmlEmail(email);
    		return "msg send sucessfully";
    		
    	}
    	catch(Exception e) {
    		return "internal issuse try again";
    	}
    }
    @PostMapping("/attach")
    public String sendAttachment(@RequestParam String to,@RequestParam String subject,@RequestParam String body) {
    	try {
    		service.sendEmailWithAttachment(to,subject,body);
    		return "msg send sucessfully";
    		
    	}
    	catch(Exception e) {
    		return "internal issuse try again";
    	}
    }
    

    
}
