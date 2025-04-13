package com.example.TestApp.config;

import com.example.TestApp.services.BluePrinter;
import com.example.TestApp.services.ColourPrinter;
import com.example.TestApp.services.GreenPrinter;
import com.example.TestApp.services.RedPrinter;
import com.example.TestApp.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter(){
        return new SpanishBluePrinter();
    }

    @Bean
    public GreenPrinter greenPrinter(){
        return new SpanishGreenPrinter();
    }

    @Bean
    public RedPrinter redPrinter(){
        return new SpanishRedPrinter();
    }

    @Bean
    public ColourPrinter colourPrinter(RedPrinter redPrinter, GreenPrinter greenPrinter, BluePrinter bluePrinter){
        return new ColourPrinterImpl(redPrinter,greenPrinter,bluePrinter);
    }
}
