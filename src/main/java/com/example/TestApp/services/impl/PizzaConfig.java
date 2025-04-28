package com.example.TestApp.services.impl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pizza")
public class PizzaConfig {

    private String sauce;
    private String topping;
    private String crust;

    public PizzaConfig(){

    }

    public void setSauce(String sauce){
        this.sauce = sauce;
    }
    public String getSauce(){
        return sauce;
    }

    public String getTopping(){
        return topping;
    }
    public void setTopping(String topping){
        this.topping = topping;
    }

    public String getCrust(){
        return crust;
    }
    public void setCrust(String crust){
        this.crust = crust;
    }
}
