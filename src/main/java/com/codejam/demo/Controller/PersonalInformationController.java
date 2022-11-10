package com.codejam.demo.Controller;

import com.codejam.demo.Model.PersonalInformation;
import com.codejam.demo.Service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api")
public class PersonalInformationController {

   @Autowired
    private PersonalInformationService personalInformationService;

    //show all personal information available
    @GetMapping("/personal-information")
    public ResponseEntity<List<PersonalInformation>> getAllPersonalInformation() {
        try{
            return new  ResponseEntity<>(personalInformationService.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //function show individual personal information
    @GetMapping("/personal-information/{id}")
    public ResponseEntity<PersonalInformation> getPersonalInformationById(@PathVariable int id) {

        try{

        return new ResponseEntity<>(personalInformationService.findById(id).orElse(null), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //create new personal information
    @PostMapping("/personal-information")
    public ResponseEntity<PersonalInformation> createPersonalInformation(@RequestBody PersonalInformation personalInformation) {
        try {
            System.out.println(personalInformation.getId());
            System.out.println(personalInformation.getAddress());
            System.out.println(personalInformation.getReal_name());
            System.out.println(personalInformation.getIdol_name());
            PersonalInformation _personalInformation = personalInformationService.savePersonalInformation(new PersonalInformation(personalInformation.getId(),personalInformation.getReal_name(), personalInformation.getIdol_name(), personalInformation.getAddress(),personalInformation.getIdol_status()));
            return new ResponseEntity<>(_personalInformation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //function to update personal information
    @PutMapping("/personal-information/{id}")
    public ResponseEntity<PersonalInformation> updatePersonalInformation(@PathVariable("id") int id, @RequestBody  PersonalInformation personalInformation) {

        System.out.println(id);
        Optional<PersonalInformation> personalData = personalInformationService.findById(id);

        if (personalData.isPresent()) {

            return new ResponseEntity<>( personalInformationService.updatePersonalInformation(id,personalInformation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //function to delete personal information
    @DeleteMapping("/personal-information/{id}")
    public ResponseEntity<HttpStatus> deletePersonalInformation(@PathVariable("id") int id) {
        try {
            personalInformationService.deleteById( id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
