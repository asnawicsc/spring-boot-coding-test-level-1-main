package com.codejam.demo.Controller;

import com.codejam.demo.Model.Revenue;
import com.codejam.demo.Model.Schedule;
import com.codejam.demo.Service.RevenueService;
import com.codejam.demo.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class ScheduleController {


    @Autowired
    private ScheduleService scheduleService;

    //show all Schedule available
    @GetMapping("/schedule")
    public ResponseEntity<List<Schedule>> getAllSchedule() {
        try{
            return new  ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //function show individual Schedule
    @GetMapping("/schedule/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable int id) {

        try{

            return new ResponseEntity<>(scheduleService.findById(id).orElse(null), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //create new Schedule
    @PostMapping("/schedule")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule) {
        try {
            System.out.println(schedule.getId());
            System.out.println(schedule.getVenue());
            System.out.println(schedule.getEvent_name());
            System.out.println(schedule.getDate_time());
            Schedule _schedule = scheduleService.saveSchedule(new Schedule(schedule.getId(),schedule.getVenue(), schedule.getEvent_name(), schedule.getDate_time()));
            return new ResponseEntity<>(_schedule, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //function to update Schedule
    @PutMapping("/schedule/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable("id") int id, @RequestBody  Schedule schedule) {

        System.out.println(id);
        Optional<Schedule> personalData = scheduleService.findById(id);

        if (personalData.isPresent()) {

            return new ResponseEntity<>( scheduleService.updateSchedule(id,schedule), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //function to deleteSchedule
    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<HttpStatus> deleteSchedule(@PathVariable("id") int id) {
        try {
            scheduleService.deleteById( id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
