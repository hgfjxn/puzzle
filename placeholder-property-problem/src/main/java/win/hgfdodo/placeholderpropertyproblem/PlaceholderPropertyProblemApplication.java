package win.hgfdodo.placeholderpropertyproblem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class PlaceholderPropertyProblemApplication implements CommandLineRunner {

    @Value("${db.user}")
    private String user;

    public static void main(String[] args) {
        SpringApplication.run(PlaceholderPropertyProblemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("user: " + user);
    }
}
