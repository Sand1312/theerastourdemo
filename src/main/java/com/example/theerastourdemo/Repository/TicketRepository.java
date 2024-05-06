package com.example.theerastourdemo.Repository;

import com.example.theerastourdemo.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
