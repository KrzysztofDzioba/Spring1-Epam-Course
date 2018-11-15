package ua.epam.spring.hometask.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.BookingDatabase;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private DiscountService discountServiceImpl;

    @Autowired
    private BookingDatabase bookedTickets;

    @Override
    public double getTicketsPrice(@Nonnull Event event,
                                  @Nonnull LocalDateTime dateTime,
                                  @Nullable User user,
                                  @Nonnull Set<Long> seats) {
        double priceSum = 0;
        double basePrice = event.getBasePrice();
        Set<Long> vipSeats = event.getAuditoriums().get(dateTime).getVipSeats();
        for (Long auditoriumVipSeat : vipSeats) {
            if (seats.contains(auditoriumVipSeat))
                priceSum += basePrice * 1.5;
            else
                priceSum += basePrice;
        }
        byte discount = discountServiceImpl.getDiscount(user, event, dateTime, seats.size());
        return priceSum - priceSum * discount;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        tickets.forEach(ticket -> {
            if (ticket.getUser().getEmail() != null)
                ticket.getUser().getTickets().add(ticket);
            bookedTickets.add(ticket);
        });
    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return bookedTickets.stream()
                .filter(ticket -> ticket.getEvent().equals(event) && ticket.getDateTime().equals(dateTime))
                .collect(Collectors.toSet());
    }
}
