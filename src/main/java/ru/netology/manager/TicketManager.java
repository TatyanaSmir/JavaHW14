package ru.netology.manager;

import java.util.Arrays;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDeparture().equalsIgnoreCase(from) && ticket.getArrival().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}



