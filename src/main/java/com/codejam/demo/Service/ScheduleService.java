package com.codejam.demo.Service;

import java.util.List;
import java.util.Optional;

import com.codejam.demo.Model.Schedule;
import com.codejam.demo.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    //function to list all Schedule exist in database
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    //function to find specific Schedule base on Schedule id
    public Optional<Schedule> findById(int id) {
        return scheduleRepository.findById(id);
    }

    //function to save Schedule into database
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    //function to update Schedule detail
    public Schedule updateSchedule(int id, Schedule schedule) {
        Schedule updateSchedule = scheduleRepository.findById(id).orElse(null);

        updateSchedule.setVenue(schedule.getVenue());
        updateSchedule.setEvent_name(schedule.getEvent_name());
        updateSchedule.setDate_time(schedule.getDate_time());


        return scheduleRepository.save(updateSchedule);
    }

    //function to delete Schedule base on Schedule id
    public void deleteById(int id) {
        scheduleRepository.deleteById(id);
    }
}
