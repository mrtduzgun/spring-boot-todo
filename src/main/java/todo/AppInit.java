package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@SpringBootApplication
public class AppInit {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(AppInit.class, args);
    }
}
