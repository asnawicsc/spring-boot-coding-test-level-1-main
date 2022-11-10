package com.codejam.demo.Service;
import java.util.List;
import java.util.Optional;

import com.codejam.demo.Model.Revenue;
import com.codejam.demo.Repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RevenueService {


    @Autowired
    private RevenueRepository revenueRepository;

    //function to list all Revenue exist in database
    public List<Revenue> findAll() {
        return revenueRepository.findAll();
    }

    //function to find specific Revenue base on Revenue id
    public Optional<Revenue> findById(int id) {
        return revenueRepository.findById(id);
    }

    //function to save Revenue into database
    public Revenue saveRevenue(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    //function to update Revenue detail
    public Revenue updateRevenue(int id, Revenue revenue) {
        Revenue updateRevenue = revenueRepository.findById(id).orElse(null);

        updateRevenue.setMonthly_rate(revenue.getMonthly_rate());
        updateRevenue.setEvent_name(revenue.getEvent_name());
        updateRevenue.setDate_time(revenue.getDate_time());


        return revenueRepository.save(updateRevenue);
    }

    //function to delete Revenue base on Revenue id
    public void deleteById(int id) {
        revenueRepository.deleteById(id);
    }

}
