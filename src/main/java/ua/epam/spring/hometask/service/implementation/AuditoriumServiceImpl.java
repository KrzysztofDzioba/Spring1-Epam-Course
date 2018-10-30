package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.dao.AuditoriumDatabase;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class AuditoriumServiceImpl implements AuditoriumService {

    private AuditoriumDatabase auditoriumDatabase;

    @Nonnull
    @Override
    public Set<Auditorium> getAll() {
        return auditoriumDatabase.getAll();
    }

    @Nullable
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return auditoriumDatabase.stream()
                .filter(auditorium -> auditorium.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void setAuditoriumDatabase(AuditoriumDatabase auditoriumDatabase) {
        this.auditoriumDatabase = auditoriumDatabase;
    }
}
