package co.com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "co.com.practice" })
public class Practice {

    public static void main(String[] args) {
        SpringApplication.run(Practice.class, args);
    }

}
