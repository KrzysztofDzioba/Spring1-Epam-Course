package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class EventDatabase {

    private Set<Event> events = new HashSet<>();

    public Stream<Event> stream() {
        return events.stream();
    }

    public void add(Event object) {
        events.add(object);
    }

    public void remove(Event object) {
        events.remove(object);
    }

    public Collection<Event> getAll() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
