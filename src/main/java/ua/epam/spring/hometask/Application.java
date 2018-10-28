package ua.epam.spring.hometask;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.hometask.domain.Auditorium;

public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Auditorium auditoriumMinimum = (Auditorium) context.getBean("auditoriumMinimum");
        System.out.println(auditoriumMinimum.getName());
    }
}
