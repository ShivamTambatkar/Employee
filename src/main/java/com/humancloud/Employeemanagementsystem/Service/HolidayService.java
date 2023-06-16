package com.humancloud.Employeemanagementsystem.Service;


import com.humancloud.Employeemanagementsystem.DTO.HolidayDTO;

import java.util.List;

public interface HolidayService {
    String createHoliday(HolidayDTO holidayDTO);

    List<HolidayDTO> getAllHolidays();

    HolidayDTO getHolidayById(Integer id);

    String updateHoliday(Integer id, HolidayDTO holidayDTO);

    String deleteHolidayById(Integer id);
}
