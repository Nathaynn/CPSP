package com.mitiara.backend.services;
import com.mitiara.backend.dtos.ScheduleTimeDTO;
import com.mitiara.backend.models.Schedule;
import com.mitiara.backend.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    //create operations
    @Override
    public ResponseEntity<Object> saveSchedule(Schedule schedule) {
        try {
            scheduleRepository.save(schedule);
            return ResponseEntity.ok(schedule);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Schedule" + e.getMessage());
        }

    }

    //read operations
    @Override
    public ResponseEntity<Object> fetchSchedule(Integer id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        if (schedule.isPresent()){
            return ResponseEntity.ok(schedule.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //update operations
    @Override
    public ResponseEntity<Object> updateWeekday(Integer id, String weekday){
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        if (schedule.isPresent()){
            Schedule saved = schedule.get();
            saved.setWeekday(weekday);
            try{
                scheduleRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Schedule" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Object> updateTime(Integer id, ScheduleTimeDTO time){
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        if (schedule.isPresent()){
            Schedule saved = schedule.get();
            saved.setInitTime(time.getInitTime());
            saved.setEndTime(time.getEndTime());
            try{
                scheduleRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Schedule" + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //delete operations
    @Override
    public ResponseEntity<Void> deleteSchedule(Integer id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        if (schedule.isPresent()){
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}


