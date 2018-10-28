package ua.epam.spring.hometask.service;

import ua.epam.spring.hometask.domain.Discount;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;

public interface DiscountStrategy {
    Discount getDiscount(User user, long numberOfTickets, LocalDateTime airDate);
}
