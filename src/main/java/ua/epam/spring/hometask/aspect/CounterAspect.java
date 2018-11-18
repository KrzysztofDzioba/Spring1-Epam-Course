package ua.epam.spring.hometask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.service.EventService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Aspect
@Component
public class CounterAspect {

    @Autowired
    private EventService eventServiceImpl;

    private static int COUNTER = 1;
    public static Map<String, Integer> eventAccessCounter = new HashMap<>();
    public static Map<String, Integer> eventPriceAccessCounter = new HashMap<>();
    public static Map<String, Integer> eventTicketBookingCounter = new HashMap<>();

    @Before("eventAccess()")
    public void countEventAccess(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String eventName = (String) args[0];
        if (eventAccessCounter.containsKey(eventName))
            eventAccessCounter.put(eventName, eventAccessCounter.get(eventName) + 1);
        else
            eventAccessCounter.put(eventName, 1);
    }

    @Before("priceAccess()")
    public void priceAccess(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String eventName = (String) args[0];
        if (eventPriceAccessCounter.containsKey(eventName))
            eventPriceAccessCounter.put(eventName, eventPriceAccessCounter.get(eventName) + 1);
        else
            eventPriceAccessCounter.put(eventName, 1);
    }

    @Before("ticketBooking()")
    public void ticketBooking(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HashSet<Ticket> tickets = (HashSet<Ticket>) args[0];
        tickets.forEach((ticket) -> {
            String eventName = ticket.getEvent().getName();
            if (eventTicketBookingCounter.containsKey(eventName))
                eventTicketBookingCounter.put(eventName, eventTicketBookingCounter.get(eventName) + 1);
            else
                eventTicketBookingCounter.put(eventName, 1);
        });

    }

    @Pointcut("execution(* getByName*(..))")
    private void eventAccess() {
    }

    @Pointcut("execution(* getEventBasePrice*(..))")
    private void priceAccess() {
    }

    @Pointcut("execution(* bookTickets*(..))")
    private void ticketBooking() {
    }
}