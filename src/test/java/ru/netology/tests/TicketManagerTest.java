package ru.netology.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 10_000, "KUF", "FRU", 150);
    Ticket ticket2 = new Ticket(2, 1_000, "MUR", "AUF", 200);
    Ticket ticket3 = new Ticket(3, 80_000, "GBL", "MDK", 300);
    Ticket ticket4 = new Ticket(4, 5_000, "MGK", "NID", 120);
    Ticket ticket5 = new Ticket(5, 19_000, "KUF", "FRU", 150);


    @BeforeEach
    public void shouldSaveAll() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
    }

    @Test
    public void shouldFindAll() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {

        repo.removeById(2);

        Ticket[] expected ={ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveNonExistentTicket() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(6);
        });
    }

    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.findAll("GBL", "MDK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTickets() {

        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.findAll("KUF", "FRU");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("MGK", "GBL");

        Assertions.assertArrayEquals(expected, actual);
    }


}
