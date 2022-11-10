package com.codejam.demo.Controller;

import com.codejam.demo.Model.Revenue;
import com.codejam.demo.Service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class RevenueController {


    @Autowired
    private RevenueService revenueService;

    //show all Revenue available
    @GetMapping("/revenue")
    public ResponseEntity<List<Revenue>> getAllRevenue() {
        try{
            return new  ResponseEntity<>(revenueService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //function show individual Revenue
    @GetMapping("/revenue/{id}")
    public ResponseEntity<Revenue> getRevenueById(@PathVariable int id) {

        try{

            return new ResponseEntity<>(revenueService.findById(id).orElse(null), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //create new Revenue
    @PostMapping("/revenue")
    public ResponseEntity<Revenue> createRevenue(@RequestBody Revenue revenue) {
        try {
            System.out.println(revenue.getId());
            System.out.println(revenue.getMonthly_rate());
            System.out.println(revenue.getEvent_name());
            System.out.println(revenue.getDate_time());
            Revenue _revenue = revenueService.saveRevenue(new Revenue(revenue.getId(),revenue.getMonthly_rate(), revenue.getEvent_name(), revenue.getDate_time()));
            return new ResponseEntity<>(_revenue, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //function to update Revenue
    @PutMapping("/revenue/{id}")
    public ResponseEntity<Revenue> updateRevenue(@PathVariable("id") int id, @RequestBody  Revenue revenue) {

        System.out.println(id);
        Optional<Revenue> personalData = revenueService.findById(id);

        if (personalData.isPresent()) {

            return new ResponseEntity<>( revenueService.updateRevenue(id,revenue), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //function to deleteRevenue
    @DeleteMapping("/revenue/{id}")
    public ResponseEntity<HttpStatus> deleteRevenue(@PathVariable("id") int id) {
        try {
            revenueService.deleteById( id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
