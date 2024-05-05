package com.example.tickettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tickettracker.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
