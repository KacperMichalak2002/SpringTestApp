package com.example.TestApp;

import com.example.TestApp.services.ColourPrinter;
import com.example.TestApp.services.impl.ColourPrinterImpl;
import com.example.TestApp.services.impl.PizzaConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAppApplication implements CommandLineRunner {

	//private ColourPrinter colourPrinter;
	private PizzaConfig pizzaConfig;

	public TestAppApplication(PizzaConfig pizzaConfig){
		this.pizzaConfig = pizzaConfig;

	}

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(String.format("I want a %s crust pizza, with %s and %s sauce",
				pizzaConfig.getCrust(),
				pizzaConfig.getTopping(),
				pizzaConfig.getSauce()));
	}
}
