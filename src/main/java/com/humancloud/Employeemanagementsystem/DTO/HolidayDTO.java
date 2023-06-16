package com.humancloud.Employeemanagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayDTO {

    private Integer id;
    private String title;
    private Date date;
    private String traditions;

}
