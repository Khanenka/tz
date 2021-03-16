package it.academy;


import java.util.List;

public interface CardDao {

    String save(Card card);


    Card getCardToClient1(Card card, String personId);


    List<String> getAllOwnerId(Currency currency, TypeCard typeCard);


}
