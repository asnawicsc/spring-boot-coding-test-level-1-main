package com.codejam.demo.Model;

import java.time.LocalDateTime;

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
public class Revenue {

    // all product attribute
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String monthly_rate;
    private String event_name;
    private String date_time;

}
