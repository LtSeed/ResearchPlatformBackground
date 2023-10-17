package cqu.mve.ResearchPlatformBackground;

import cqu.mve.ResearchPlatformBackground.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication
public class ResearchPlatformBackgroundApplication {


	public static void main(String[] args) {
		SpringApplication.run(ResearchPlatformBackgroundApplication.class, args);
		System.out.println("jj");

	}

}
