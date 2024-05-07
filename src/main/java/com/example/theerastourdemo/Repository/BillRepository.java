package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Bill;
import com.example.theerastourdemo.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {


    List<Bill> findAll();


    List<Bill> findByIdOrderByIdDesc(Tour tour);

}
