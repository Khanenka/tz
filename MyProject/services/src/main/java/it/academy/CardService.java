package it.academy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CardService {

    @Autowired
    CardDao cardDao;

    @Autowired
    PersonDao personDao;


    @Transactional
    public Card saveNewCardToPerson1(Card card, String id) {

        cardDao.getCardToClient1(card, id);
        cardDao.save(card);
        return card;
    }


    @Transactional
    public Card saveCard(Card card) {
        cardDao.save(card);
        return card;
    }



    @Transactional
    public List<String> getAllPhones(TypeCard typeCard, Currency currency) {
        List<String> allOwnerId = cardDao.getAllOwnerId(currency, typeCard);
        List<Person> people = new ArrayList<>();
        for (String id : allOwnerId) {
            people.add(personDao.getOnePerson(id));
        }
        List<String> collect = people.stream().map(person -> person.getPersonPhone()).collect(Collectors.toList());

        return collect;


    }

}
