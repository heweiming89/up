package cn.heweiming.up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootApplication(exclude = { SchedulingConfiguration.class })
public class UpApplication {

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(UpApplication.class, args);
//		app.setShowBanner(false);
//		app.run(args);
		SpringApplication.run(UpApplication.class, args);
	
	}
}
