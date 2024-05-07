package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
