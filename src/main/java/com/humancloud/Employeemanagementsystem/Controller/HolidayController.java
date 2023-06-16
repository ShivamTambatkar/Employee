package com.humancloud.Employeemanagementsystem.Controller;


import com.humancloud.Employeemanagementsystem.DTO.HolidayDTO;
import com.humancloud.Employeemanagementsystem.Service.HolidayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/holidays")
@Tag(name = "Holiday")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @PostMapping("/create")
    public ResponseEntity<String> createHoliday(@RequestBody HolidayDTO holidayDTO) {
        String holiday = this.holidayService.createHoliday(holidayDTO);
        return new ResponseEntity<String>(holiday, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HolidayDTO>> getAllHolidays() {
        List<HolidayDTO> allHolidays = this.holidayService.getAllHolidays();
        return ResponseEntity.ok(allHolidays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayDTO> getHolidayById(@PathVariable Integer id){
        HolidayDTO holidayById = this.holidayService.getHolidayById(id);
        return new ResponseEntity<>(holidayById,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateHoliday(@PathVariable Integer id, @RequestBody HolidayDTO holidayDTO){
        String updateHoliday = this.holidayService.updateHoliday(id, holidayDTO);
        return new ResponseEntity<String>(updateHoliday,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHolidayById(@PathVariable Integer id){
        String holidayDTO = this.holidayService.deleteHolidayById(id);
        return new ResponseEntity<String>(holidayDTO,HttpStatus.CREATED);
    }
}
