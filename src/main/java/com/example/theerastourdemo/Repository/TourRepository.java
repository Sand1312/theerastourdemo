package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {

    List<Tour> findAll();

    Tour findTourById(int id);


}
