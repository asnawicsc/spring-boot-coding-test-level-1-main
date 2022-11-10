package com.codejam.demo.Service;

import com.codejam.demo.Model.PersonalInformation;
import com.codejam.demo.Repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    //function to list all PersonalInformation exist in database
    public List<PersonalInformation> findAll() {
        return personalInformationRepository.findAll();
    }

    //function to find specific PersonalInformation base on PersonalInformation id
    public Optional<PersonalInformation> findById(int id) {
        return personalInformationRepository.findById(id);
    }

    //function to save PersonalInformation into database
    public PersonalInformation savePersonalInformation(PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    //function to update PersonalInformation detail
    public PersonalInformation updatePersonalInformation(int id, PersonalInformation personalInformation) {
        PersonalInformation updatePersonalInformation = personalInformationRepository.findById(id).orElse(null);

        updatePersonalInformation.setReal_name(personalInformation.getReal_name());
        updatePersonalInformation.setIdol_name(personalInformation.getIdol_name());
        updatePersonalInformation.setAddress(personalInformation.getAddress());
        updatePersonalInformation.setIdol_status(personalInformation.getIdol_status());


        return personalInformationRepository.save(updatePersonalInformation);
    }

    //function to delete PersonalInformation base on PersonalInformation id
    public void deleteById(int id) {
        personalInformationRepository.deleteById(id);
    }
}
