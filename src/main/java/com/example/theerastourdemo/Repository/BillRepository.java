package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
