package com.humancloud.Employeemanagementsystem.Config;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class javaMailConfig {
    @Value("${spring.mail.host}")
    private String mailhost;
    @Value("${spring.mail.port}")
    private String mailPort;
    @Value("${spring.mail.username}")
    private String mailUserName;
    @Value("${spring.mail.password}")
    private String mailPassword;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailhost);
        javaMailSender.setPort(Integer.parseInt(mailPort));
        javaMailSender.setUsername(mailUserName);
        javaMailSender.setPassword(mailPassword);
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true");


        return javaMailSender;
    }

}
