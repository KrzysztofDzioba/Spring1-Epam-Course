package ua.epam.spring.hometask.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
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
public class AppConfiguration {

    //auditorium Maximum
    @Value("${auditorium.maximum.name}")
    private String maximumName;

    @Value("${auditorium.maximum.seats}")
    private Long maximumSeats;

    @Value("${auditorium.maximum.vip.seats}")
    private String maximumVipSeats;

    //auditorium Minimum
    @Value("${auditorium.minimum.name}")
    private String minimumName;

    @Value("${auditorium.minimum.seats}")
    private Long minimumSeats;

    @Value("${auditorium.minimum.vip.seats}")
    private String minimumVipSeats;

//    @Bean
//    public AppTest appTest() {
//        return new AppTest();
//    }

//    @Bean
//    public DomainObjectDatabase domainObjectDatabase() {
//        return new DomainObjectDatabase();
//    }

//    @Bean
//    public AuditoriumDatabase auditoriumDatabase() {
//        return new AuditoriumDatabase();
//    }

//    @Bean
//    public Auditorium auditorium() {
//        return new Auditorium(maximumName, maximumSeats, maximumVipSeats);
//    }

    @Bean
    public Set<Auditorium> auditoriums() {
        Auditorium auditoriumMaximum = new Auditorium(maximumName, maximumSeats, maximumVipSeats);
        Auditorium auditoriumMinimum = new Auditorium(minimumName, minimumSeats, minimumVipSeats);
        Set<Auditorium> auditoriums = new HashSet<>();
        auditoriums.add(auditoriumMaximum);
        auditoriums.add(auditoriumMinimum);
        return auditoriums;
    }

//    @Bean
//    public DiscountStrategyBirthday discountStrategyBirthday() {
//        return new DiscountStrategyBirthday();
//    }
//
//    @Bean
//    public DiscountStrategyEvery10Tickets discountStrategyEvery10Tickets() {
//        return new DiscountStrategyEvery10Tickets();
//    }

//    @Bean
//    public BookingDatabase bookingDatabase() {
//        return new BookingDatabase();
//    }

//    @Bean
//    public StrategiesDatabase strategiesDatabase() {
//        return new StrategiesDatabase();
//    }

//    @Bean
//    public EventDatabase eventDatabase() {
//        return new EventDatabase();
//    }

//    @Bean
//    public UserDatabase userDatabase() {
//        return new UserDatabase();
//    }

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
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
