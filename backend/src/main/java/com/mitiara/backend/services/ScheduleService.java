package com.mitiara.backend.services;

import com.mitiara.backend.dtos.ScheduleTimeDTO;
import com.mitiara.backend.models.Schedule;
import org.springframework.http.ResponseEntity;

public interface ScheduleService {

    // create operations
    ResponseEntity<Object> saveSchedule(Schedule schedule);

    //read operations
    ResponseEntity<Object> fetchSchedule(Integer id);

    //update operations

    ResponseEntity<Object> updateWeekday(Integer id, String weekday);

    ResponseEntity<Object> updateTime(Integer id, ScheduleTimeDTO scheduleTime);

    //delete operations
    ResponseEntity <Void> deleteSchedule(Integer id);

}


