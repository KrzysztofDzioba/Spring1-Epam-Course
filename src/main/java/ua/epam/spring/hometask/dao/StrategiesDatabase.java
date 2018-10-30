package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.service.DiscountStrategy;

import java.util.List;

public class StrategiesDatabase {

    private List<DiscountStrategy> strategies;


    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public List<DiscountStrategy> getAll() {
        return strategies;
    }
}
