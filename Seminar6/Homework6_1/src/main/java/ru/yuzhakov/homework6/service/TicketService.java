package ru.yuzhakov.homework6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuzhakov.homework6.model.Ticket;
import ru.yuzhakov.homework6.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;

    public Ticket add(Ticket ticket) {
        ticket.setCreatedDateTime(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket get(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket update(Long id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setContent(ticket.getContent());
            existingTicket.setTitle(ticket.getTitle());
            existingTicket.setCreatedDateTime(ticket.getCreatedDateTime());
            return existingTicket;
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }
}
