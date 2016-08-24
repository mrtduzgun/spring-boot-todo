package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by murat.duzgun on 16.8.2016.
 */

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
public class AppInit {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(AppInit.class, args);
    }
}
