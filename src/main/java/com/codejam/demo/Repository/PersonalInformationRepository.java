package com.codejam.demo.Repository;

import com.codejam.demo.Model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Integer> {


}
