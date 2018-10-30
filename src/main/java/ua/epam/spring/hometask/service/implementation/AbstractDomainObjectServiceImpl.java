package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.dao.DomainObjectDatabase;
import ua.epam.spring.hometask.domain.DomainObject;
import ua.epam.spring.hometask.service.AbstractDomainObjectService;

import javax.annotation.Nonnull;
import java.util.*;

public class AbstractDomainObjectServiceImpl implements AbstractDomainObjectService {

    private DomainObjectDatabase domainObjects;

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
    public Collection<DomainObject> getAll() {
        return domainObjects.getAll();
    }

    public void setDomainObjects(DomainObjectDatabase domainObjects) {
        this.domainObjects = domainObjects;
    }
}
