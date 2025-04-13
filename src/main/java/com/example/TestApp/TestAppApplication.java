package com.example.TestApp;

import com.example.TestApp.services.ColourPrinter;
import com.example.TestApp.services.impl.ColourPrinterImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAppApplication implements CommandLineRunner {

	private ColourPrinter colourPrinter;

	public TestAppApplication(ColourPrinter colourPrinter){
		this.colourPrinter = colourPrinter;

	}

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(colourPrinter.print());
	}
}
