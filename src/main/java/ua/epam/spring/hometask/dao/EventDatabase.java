package ua.epam.spring.hometask.dao;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Component
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
}
