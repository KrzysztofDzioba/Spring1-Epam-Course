package ua.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Set;
import java.util.stream.Stream;

@Component
public class AuditoriumDatabase {

    @Autowired
    private Set<Auditorium> auditoriums;

    public Stream<Auditorium> stream() {
        return auditoriums.stream();
    }

    public Set<Auditorium> getAll() {
        return auditoriums;
    }

}
