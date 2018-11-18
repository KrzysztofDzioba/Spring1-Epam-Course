package ua.epam.spring.hometask.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.service.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
        Event event1 = eventServiceImpl.getByName("event1");
        User user = new User();
        user.setEmail("elo");
        user.setBirthday(LocalDate.of(1993, 10, 6));
        Set<Ticket> tickets = new HashSet<>();
        tickets.add(new Ticket(user, event1, LocalDateTime.now(), 10));
        bookingServiceImpl.bookTickets(tickets);
        discountServiceImpl.getDiscount(user, event1, LocalDateTime.now(), 1);
    }

}
