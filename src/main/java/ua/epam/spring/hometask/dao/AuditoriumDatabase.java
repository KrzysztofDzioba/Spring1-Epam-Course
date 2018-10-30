package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Set;
import java.util.stream.Stream;

public class AuditoriumDatabase {

    private static Set<Auditorium> auditoriums;

    public Stream<Auditorium> stream() {
        return auditoriums.stream();
    }

    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        AuditoriumDatabase.auditoriums = auditoriums;
    }
}
