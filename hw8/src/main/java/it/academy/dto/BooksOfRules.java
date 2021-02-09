package it.academy.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "it.academy.dto")

public class BooksOfRules {

    private int id;
    private ReadRules readRules;


    @Autowired(required = false)
    public BooksOfRules(ReadRules readRules) {
        this.id = 1;
        this.readRules = readRules;
    }



    @Bean
    @Override
    public String toString() {
        return "BooksOfRules " + id + " " + readRules.readAllRules();
    }
    @Bean
   public String TakeYourSport(){
        return readRules.AllSports();
    }
}


