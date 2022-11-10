package com.codejam.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String real_name;
   private String idol_name;
   private String address;
   private String idol_status;

}
