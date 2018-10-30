package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.dao.EventDatabase;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventService {

    private EventDatabase events;

    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {
        return events.stream()
                .filter(event -> event.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event save(@Nonnull Event object) {
        events.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Event object) {
        events.remove(object);
    }

    @Nullable
    @Override
    public Event getById(@Nonnull Long id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return events.getAll();
    }

    public Set<Event> getForDateRange(LocalDateTime from, LocalDateTime to) {
        return events.stream().filter(
                (event) -> event.getAirDates().stream()
                        .anyMatch(dt -> dt.toLocalDate().compareTo(ChronoLocalDate.from(from)) >= 0
                                && dt.toLocalDate().compareTo(ChronoLocalDate.from(to)) <= 0))
                .collect(Collectors.toSet());
    }

    public void setEvents(EventDatabase events) {
        this.events = events;
    }
}
