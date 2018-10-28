package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService {

    public static Set<Auditorium> auditoriums;

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriums.stream()
                .filter(auditorium -> auditorium.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        AuditoriumServiceImpl.auditoriums = auditoriums;
    }


}
