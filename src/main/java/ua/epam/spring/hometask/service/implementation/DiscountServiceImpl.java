package ua.epam.spring.hometask.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.dao.StrategiesDatabase;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private StrategiesDatabase strategies;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        int discount = 0;
        for (DiscountStrategy discountStrategy : strategies.getAll()) {
            int discountAmount = discountStrategy.getDiscount(user, numberOfTickets, airDateTime).getDiscountAmount();
            if (discount < discountAmount)
                discount = discountAmount;
        }
        return Byte.valueOf(String.valueOf(discount));
    }

    public void setStrategies(StrategiesDatabase strategies) {
        this.strategies = strategies;
    }
}
