package win.hgfdodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import win.hgfdodo.config.Outer;

@SpringBootApplication
@EnableConfigurationProperties(Outer.class)
public class Application implements CommandLineRunner {
    @Autowired
    Outer outer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(outer);

    }
}
