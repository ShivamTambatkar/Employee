package com.humancloud.Employeemanagementsystem.Controller;

import com.humancloud.Employeemanagementsystem.Entity.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class NotificationController {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send-email")
    public  String sendEmail(@RequestBody EmailDto emailDto){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(emailDto.getTo());
        simpleMailMessage.setSubject(emailDto.getSubject());
        simpleMailMessage.setText(emailDto.getText());
        javaMailSender.send(simpleMailMessage);
        return "Email sent Successfully";


    }
    @PostMapping("/send-email-attachment")
    public  String sendEmailWithAttachment(@ModelAttribute EmailDto emailDto) throws MessagingException, IOException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(emailDto.getTo());
        mimeMessageHelper.setSubject(emailDto.getSubject());
        mimeMessageHelper.setText(emailDto.getText());
        mimeMessageHelper.addAttachment(emailDto.getAttachment().getOriginalFilename(),fileConvertMultipartToFile(emailDto.getAttachment(),emailDto.getAttachment().getOriginalFilename()));
        javaMailSender.send(mimeMessage);
        return "Email sent Successfully";

    }
    private  static File fileConvertMultipartToFile(MultipartFile multipart, String fileName) throws IOException {
        File convFile=new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

}
