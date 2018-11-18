package ua.epam.spring.hometask.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import ua.epam.spring.hometask.service.DiscountStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableAspectJAutoProxy
@PropertySource(value = {
        "classpath:auditorium_maximum.properties",
        "classpath:auditorium_minimum.properties"})
@ComponentScan(basePackages = {
        "ua.epam.spring.hometask.dao",
        "ua.epam.spring.hometask.domain",
        "ua.epam.spring.hometask.service.implementation",
        "ua.epam.spring.hometask.aspect"
})
public class AppConfiguration implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Set<Auditorium> auditoriums() {
        String maximumName = environment.getRequiredProperty("auditorium.maximum.name");
        Integer maximumSeats = environment.getRequiredProperty("auditorium.maximum.seats", Integer.class);
        String maximumVipSeats = environment.getRequiredProperty("auditorium.maximum.vip.seats");
        String minimumName = environment.getRequiredProperty("auditorium.minimum.name");
        Integer minimumSeats = environment.getRequiredProperty("auditorium.minimum.seats", Integer.class);
        String minimumVipSeats = environment.getRequiredProperty("auditorium.minimum.vip.seats");
        Auditorium auditoriumMaximum = new Auditorium(maximumName, maximumSeats, maximumVipSeats);
        Auditorium auditoriumMinimum = new Auditorium(minimumName, minimumSeats, minimumVipSeats);
        Set<Auditorium> auditoriums = new HashSet<>();
        auditoriums.add(auditoriumMaximum);
        auditoriums.add(auditoriumMinimum);
        return auditoriums;
    }

    @Autowired
    public DiscountStrategy discountStrategyBirthday;

    @Autowired
    public DiscountStrategy discountStrategyEvery10Tickets;

    @Bean
    public List<DiscountStrategy> strategies() {
        List<DiscountStrategy> strategies = new ArrayList<>();
        strategies.add(discountStrategyBirthday);
        strategies.add(discountStrategyEvery10Tickets);
        return strategies;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
