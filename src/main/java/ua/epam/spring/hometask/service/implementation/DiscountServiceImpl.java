package ua.epam.spring.hometask.service.implementation;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {

    private List<DiscountStrategy> strategies;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int discount = 0;
        for (DiscountStrategy discountStrategy : strategies) {
            int discountAmount = discountStrategy.getDiscount(user, numberOfTickets, airDateTime).getDiscountAmount();
            if (discount < discountAmount)
                discount = discountAmount;
        }
        return Byte.valueOf(String.valueOf(discount));
    }

    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }
}
