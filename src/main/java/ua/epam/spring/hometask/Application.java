package ua.epam.spring.hometask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ua.epam.spring.hometask.dao.AuditoriumDatabase;
import ua.epam.spring.hometask.domain.AppConfiguration;
import ua.epam.spring.hometask.domain.AppTest;
import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Set;

@Component
public class Application {

    @Autowired
    AppTest appTest;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        ctx.register(AppConfig.class);
//        ctx.refresh();

        AuditoriumDatabase auditoriumDatabase = (AuditoriumDatabase) ctx.getBean("auditoriumDatabase");
        Set<Auditorium> all = auditoriumDatabase.getAll();
        System.out.println(all);

        AppTest appTest = (AppTest) ctx.getBean("appTest");
        appTest.run();
    }
}
