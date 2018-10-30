package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Ticket;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BookingDatabase {

    private Set<Ticket> bookedTickets = new HashSet<>();

    public void add(Ticket ticket) {
        bookedTickets.add(ticket);
    }

    public Stream<Ticket> stream() {
        return bookedTickets.stream();
    }
}
