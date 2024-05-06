package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}
