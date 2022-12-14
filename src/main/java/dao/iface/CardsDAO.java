package dao.iface;

import domain.models.Card;
import domain.models.User;

import java.util.ArrayList;

public interface CardsDAO{
    boolean createCard(User user);
    Card readCard(String numberCard);
    ArrayList<Card> readCards(User user);
    Card updateCard();
    void deleteCard();
}
