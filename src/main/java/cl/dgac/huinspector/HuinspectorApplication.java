package cl.dgac.huinspector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "cl.dgac.huinspector")
public class HuinspectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuinspectorApplication.class, args);
	}

}
