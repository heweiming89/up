package cn.heweiming.up.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.heweiming.up.config.DispatchServletConfig;

@SpringBootApplication
public class ApplicationRun {

	public static void main(String[] args) {
		SpringApplication.run(DispatchServletConfig.class, args);
	}
	
}
