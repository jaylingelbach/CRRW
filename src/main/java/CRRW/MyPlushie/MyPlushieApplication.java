package CRRW.MyPlushie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyPlushieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPlushieApplication.class, args);
	}

}

@Component
class MyApplicationRunner implements ApplicationRunner {

//	this listener more accurately displays the message since the application context initialization and startup happen asynchronously.
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("APPLICATION STARTED!!!");
	}
}