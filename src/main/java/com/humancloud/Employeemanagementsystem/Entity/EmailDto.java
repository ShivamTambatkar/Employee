package com.humancloud.Employeemanagementsystem.Entity;

import jakarta.mail.Multipart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String to;
    private String subject;
    private String text;
    private MultipartFile attachment;
}
