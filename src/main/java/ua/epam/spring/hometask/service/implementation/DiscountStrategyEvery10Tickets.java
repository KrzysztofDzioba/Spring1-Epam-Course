package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.domain.Discount;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountStrategy;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

public class DiscountStrategyEvery10Tickets implements DiscountStrategy {

    @Nonnull
    @Override
    public Discount getDiscount(User user, long numberOfTickets, LocalDateTime airDate) {
        int size = user.getTickets().size();
        int discountAmount = size % 10 > 0 ? 10 : 0;
        return new Discount(false, discountAmount);
    }
}
