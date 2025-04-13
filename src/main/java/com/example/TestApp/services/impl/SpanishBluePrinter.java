package com.example.TestApp.services.impl;

import com.example.TestApp.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component
public class SpanishBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "azul";
    }
}
