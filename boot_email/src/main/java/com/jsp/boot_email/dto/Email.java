package com.jsp.boot_email.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Email {
	String to;
	String subject;
	String body;

}
