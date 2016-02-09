package pl.edu.uj.jg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.uj.jg.preload.DataInitializer;

@SpringBootApplication
public class RedtreeApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RedtreeApplication.class, args);
        DataInitializer dataInitializer = ctx.getBean(DataInitializer.class);
        dataInitializer.initialize();
    }
}
