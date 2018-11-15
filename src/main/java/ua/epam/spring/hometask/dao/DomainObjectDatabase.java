package ua.epam.spring.hometask.dao;

import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.DomainObject;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class DomainObjectDatabase {

    private static Set<DomainObject> domainObjects = new HashSet<>();

    public void add(DomainObject domainObject) {
        domainObjects.add(domainObject);
    }

    public Stream<DomainObject> stream() {
        return domainObjects.stream();
    }

    public void remove(DomainObject object) {
        domainObjects.remove(object);
    }

    public Set<DomainObject> getAll() {
        return domainObjects;
    }
}
