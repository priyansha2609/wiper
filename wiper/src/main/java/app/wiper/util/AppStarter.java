package app.wiper.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@MapperScan("app.wiper.mapper")
@SpringBootApplication(scanBasePackages = {"app.wiper"})
public class AppStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppStarter.class);
    }

}
