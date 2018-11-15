package ua.epam.spring.hometask.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.service.*;

@Component
public class AppTest {

    @Autowired
    private AbstractDomainObjectService<User> abstractDomainObjectServiceImpl;

    @Autowired
    private AuditoriumService auditoriumServiceImpl;

    @Autowired
    private BookingService bookingServiceImpl;

    @Autowired
    private DiscountService discountServiceImpl;

    @Autowired
    private EventService eventServiceImpl;

    @Autowired
    private UserService userServiceImpl;

    public void run() {
        eventServiceImpl.save(new Event("event1", null, 10, null, null));
        eventServiceImpl.getByName("event1");
        System.out.println("dziala?");
    }

}
