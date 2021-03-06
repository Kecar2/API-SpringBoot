package es.cabsa.javadevelopers;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws SQLException {
		SQLconnection connection = new SQLconnection();
		connection.prueba();

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Animals in the jungle:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

	
	}

}
