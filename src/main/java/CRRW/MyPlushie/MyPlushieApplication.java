package CRRW.MyPlushie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import CRRW.MyPlushie.services.UserService;

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