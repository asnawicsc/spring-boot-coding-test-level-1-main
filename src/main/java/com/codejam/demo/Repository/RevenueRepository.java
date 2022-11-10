package com.codejam.demo.Repository;


import com.codejam.demo.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevenueRepository extends JpaRepository<Revenue, Integer> {
}
