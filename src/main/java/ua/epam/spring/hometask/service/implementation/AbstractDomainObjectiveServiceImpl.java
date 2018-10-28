package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

import javax.annotation.Nonnull;
import java.util.*;

public class AbstractDomainObjectiveServiceImpl implements AbstractDomainObjectService {

    public static Set<DomainObject> domainObjects = new HashSet<>();

    @Override
    public DomainObject save(@Nonnull DomainObject object) {
        domainObjects.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull DomainObject object) {
        domainObjects.remove(object);
    }

    @Override
    public DomainObject getById(@Nonnull Long id) {
        return domainObjects.stream()
                .filter(domainObject -> domainObject.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Nonnull
    @Override
    public Collection getAll() {
        return domainObjects;
    }
}