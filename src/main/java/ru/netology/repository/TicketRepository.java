package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = item;
        tickets = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "ID " + id + " not found"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        tickets = tmp;

    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {

                return ticket;
            }
        }
        return null;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public Ticket[] findAll() {
        return tickets;
    }
}
