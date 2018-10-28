package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.domain.Discount;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DiscountStrategyBirthday implements DiscountStrategy {

    @Override
    public Discount getDiscount(User user, long numberOfTickets, LocalDateTime airDate) {
        int discountAmount = userShouldHaveBirthdayDiscount(user.getBirthday(), airDate.toLocalDate()) ? 5 : 0;
        return new Discount(true, discountAmount);
    }

    private boolean userShouldHaveBirthdayDiscount(LocalDate userBirthday, LocalDate airDate) {
        int userBirthdayDay = userBirthday.getDayOfYear();
        int airDateDayOfYear = airDate.getDayOfYear();
        return airDateDayOfYear - userBirthdayDay >= 0 && airDateDayOfYear - userBirthdayDay <= 5;
    }
}
