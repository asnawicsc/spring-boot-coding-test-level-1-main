package com.codejam.demo.Repository;

import com.codejam.demo.Model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Integer> {


}
