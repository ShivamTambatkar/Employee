package com.humancloud.Employeemanagementsystem.Service.Impl;

import com.humancloud.Employeemanagementsystem.DTO.HolidayDTO;
import com.humancloud.Employeemanagementsystem.Entity.Holiday;
import com.humancloud.Employeemanagementsystem.Exceptions.ResourceNotFoundException;
import com.humancloud.Employeemanagementsystem.Repository.HolidayRepository;
import com.humancloud.Employeemanagementsystem.Service.HolidayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String createHoliday(HolidayDTO holidayDTO) {
        Holiday holidays = modelMapper.map(holidayDTO, Holiday.class);
        holidayRepository.save(holidays);
        return "Holiday created successfully..............";
    }

    @Override
    public List<HolidayDTO> getAllHolidays() {
        List<Holiday> holidays = this.holidayRepository.findAll();

        List<HolidayDTO> holidayDTOS = holidays.stream()
                .map(holiday -> modelMapper.map(holiday, HolidayDTO.class)).
                collect(Collectors.toList());
        return holidayDTOS;
    }

    @Override
    public HolidayDTO getHolidayById(Integer id) {
        Holiday holiday = this.holidayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("holiday","id",id));
        return modelMapper.map(holiday, HolidayDTO.class);
    }


    @Override
    public String updateHoliday(Integer id, HolidayDTO holidayDTO) {
        Holiday holiday = this.holidayRepository.findById(id).get();
        holiday.setTitle(holidayDTO.getTitle() != null ? holidayDTO.getTitle() : holiday.getTitle());
        holiday.setDate(holidayDTO.getDate() != null ? holidayDTO.getDate() : holiday.getDate());
        holiday.setTraditions(holidayDTO.getTraditions() != null ? holidayDTO.getTraditions() : holiday.getTraditions());
        return "Holiday updated........";
    }

    @Override
    public String deleteHolidayById(Integer id) {
        Holiday holiday = this.holidayRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("holiday", "id", id));
        this.holidayRepository.delete(holiday);
        return "Deleted successfully...";
    }
}

