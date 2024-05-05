package ru.yuzhakov.homework6.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yuzhakov.homework6.model.Ticket;
import ru.yuzhakov.homework6.service.TicketService;

import java.util.List;

/*
    1. Добавление заметки. (Подсказка @PostMapping )
    2. Просмотр всех заметок.(Подсказка @GetMapping )
    3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
    4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
    5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
 */

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {
    private TicketService ticketService;

    @PostMapping("/add")
    public Ticket add(@RequestBody Ticket ticket) {
        return ticketService.add(ticket);
    }

    @GetMapping
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable("id") Long ticketId) {
        return ticketService.get(ticketId);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable("id") Long ticketId, @RequestBody Ticket ticket) {
        return ticketService.update(ticketId, ticket);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long ticketId) {
        ticketService.delete(ticketId);
    }
}
