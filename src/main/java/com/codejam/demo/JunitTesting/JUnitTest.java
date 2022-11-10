package com.codejam.demo.JunitTesting;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codejam.demo.Exceptions.CustomException;
import com.codejam.demo.Model.PersonalInformation;
import com.codejam.demo.Repository.PersonalInformationRepository;
import com.codejam.demo.Service.PersonalInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class JUnitTest {

    //create a function fetch random idol from personal info table.

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private PersonalInformationService personalInformationService;

    @Test
    public void testRandomIdolFetch() throws CustomException{

         int random_idol_id = 100;

        PersonalInformation pi= new PersonalInformation(random_idol_id,"Azaim","Kalim","Malaysia","ACTIVE");

        PersonalInformation data= personalInformationService.savePersonalInformation(pi);

        if (Objects.isNull(data)) {
            CustomException exp = new CustomException("No information with ID: " + 100);
            throw exp;
        }

        //by default got 1 data

        assertNotNull(personalInformationService.findById(100));

    }

    // create a unit test for this function (condition: failed if the idol is in-active)

    public void testFindIdonStatus(){

        String status ="IN-ACTIVE";

        PersonalInformation pi= new PersonalInformation(200,"Azaim","Kalim","Malaysia","IN-ACTIVE");

        personalInformationService.savePersonalInformation(pi);

        assertEquals(personalInformationService.findById(200).get().getIdol_status(),status);



    }
}
