package com.example.tickettracker.service;

import com.example.tickettracker.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();

    Optional<Ticket> getTicketById(Long id);

    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Long id, Ticket ticket);

    void deleteTicket(Long id);
}
