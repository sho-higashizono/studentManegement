package raisetech.studet.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application {


	public static void main(String[] args) {
		//localhost:8080
		SpringApplication.run(Application.class, args);
	}
}
