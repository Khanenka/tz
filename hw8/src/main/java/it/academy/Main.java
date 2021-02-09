package it.academy;

import it.academy.dto.Bascetball;
import it.academy.dto.BooksOfRules;
import it.academy.dto.ReadRules;
import it.academy.dto.Soccer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class Main {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("it.academy.dto");
        Soccer soccer=applicationContext.getBean(Soccer.class);
        System.out.println(soccer.getRule());
       Bascetball bascetball=applicationContext.getBean(Bascetball.class);
        System.out.println(bascetball.getRule());
        ReadRules readRules=applicationContext.getBean(ReadRules.class);
        System.out.println(readRules.readAllRules());
        BooksOfRules booksOfRules = applicationContext.getBean(BooksOfRules.class);
        System.out.println(booksOfRules);
        System.out.println(booksOfRules.TakeYourSport());
    }
}
