package ua.epam.spring.hometask.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.service.DiscountStrategy;

import java.util.List;

@Component
public class StrategiesDatabase {

    @Autowired
    private List<DiscountStrategy> strategies;

    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<DiscountStrategy> getAll() {
        return strategies;
    }
}
