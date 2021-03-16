package it.academy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = DaoConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CardControllerTest {

    @Autowired
    CardDao cardDaoImpl;

    @Autowired
    PersonDao personDao;
    @Autowired
    CardService cardService;

    @Test
    public void readTypeCurrency() {

//Given
        Card card = new Card();
        card.setIdCard("cardId");
        card.setTypeCard(TypeCard.Platinum);
        card.setCurrency(Currency.EUR);
        card.setNumberCard("numberCard11");
        card.setId_Person("personId");

        Card card1 = new Card();
        card.setIdCard("cardId1");
        card.setTypeCard(TypeCard.Platinum);
        card.setCurrency(Currency.EUR);
        card.setNumberCard("numberCard22");
        card.setId_Person("personId");

        Person person = new Person();
        person.setPersonId("personId");
        person.setPersonFirstName("FirstName1");
        person.setPersonMiddleName("MiddleName1");
        person.setPersonLastName("LastName1");
        person.setPersonEMail("www@mail.ru");
        person.setPersonPhone("+375233322");
        person.setStatus(Status.status_0);


//when

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        List<String> personId = cardDaoImpl.getAllOwnerId(Currency.EUR, TypeCard.Platinum);
        System.out.println("==========================================================");
        List <Person> people=new ArrayList<>();
        for (String id : personId) {
            people.add((Person) personDao.getOnePerson(id));
        }


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(people);
        List <String> phone=new ArrayList<>();
            for (Person person1 : people) {
                phone.add(person1.getPersonPhone());
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(phone);


//        assertNotNull(phones);

    }
}