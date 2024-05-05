package ru.yuzhakov.homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.homework6.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
