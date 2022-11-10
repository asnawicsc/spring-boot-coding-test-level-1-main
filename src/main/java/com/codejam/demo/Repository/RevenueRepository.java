package com.codejam.demo.Repository;


import com.codejam.demo.Model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Integer> {
}
