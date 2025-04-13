package com.example.TestApp.services.impl;

import com.example.TestApp.services.BluePrinter;
import com.example.TestApp.services.ColourPrinter;
import com.example.TestApp.services.GreenPrinter;
import com.example.TestApp.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class ColourPrinterImpl implements ColourPrinter {

    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    public ColourPrinterImpl(RedPrinter redPrinter, GreenPrinter greenPrinter, BluePrinter bluePrinter){
        this.redPrinter = redPrinter;
        this.greenPrinter = greenPrinter;
        this.bluePrinter = bluePrinter;
    }

    @Override
    public String print() {
        return String.join(",",redPrinter.print(), greenPrinter.print(), bluePrinter.print());
    }
}
