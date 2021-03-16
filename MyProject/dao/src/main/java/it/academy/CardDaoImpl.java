package it.academy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardDaoImpl implements CardDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CardDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public String save(Card card) {
        Session session = sessionFactory.getCurrentSession();


        String id = (String) session.save(card);

        return id;


    }


    @Override
    public Card getCardToClient1(Card card, String personId) {

        card.setId_Person(personId);
        return card;
    }


    @Override
    public List<String> getAllOwnerId(Currency currency, TypeCard typeCard) {
        Session session = sessionFactory.getCurrentSession();

        List<Card> list1 = session.createQuery("from Card  WHERE currency='" + currency + "' and typeCard='" + typeCard + "'", Card.class)
                .list();
        List<String> list = new ArrayList<>();
        list1.stream().forEach(card -> list.add(card.getId_Person()));

        return list;
    }
}







