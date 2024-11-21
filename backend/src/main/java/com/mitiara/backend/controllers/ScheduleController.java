package com.mitiara.backend.controllers;

import com.mitiara.backend.dtos.ScheduleTimeDTO;
import com.mitiara.backend.models.Schedule;
import com.mitiara.backend.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

    @Autowired
    public ScheduleService scheduleService;

    //create operations
    @PostMapping("/")
    public ResponseEntity<Object> addSchedule (@RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    //read operations
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchSchedule(@PathVariable("id") Integer id) {
        return scheduleService.fetchSchedule(id);
    }

    //update operations
    @PutMapping("/weekday/{id}")
    public ResponseEntity<Object> updateWeekday(@PathVariable ("id") Integer id, @RequestBody String weekday){
        return scheduleService.updateWeekday(id, weekday);
    }

    @PutMapping("/time/{id}")
    public ResponseEntity<Object> updateTime(@PathVariable ("id") Integer id, @RequestBody ScheduleTimeDTO time) {
        return scheduleService.updateTime(id, time);
    }

    //delete operations
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable("id") Integer id) {
        return scheduleService.deleteSchedule(id);
    }

}
