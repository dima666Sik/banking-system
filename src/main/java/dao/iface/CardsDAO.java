package dao.iface;

import domain.models.Card;
import domain.models.User;

import java.util.ArrayList;

public interface CardsDAO{
    void createCard(User user);
    Card readCard(String numberCard, User user);
    Card readCard(int userId);
    ArrayList<Card> readCards(User user);
    Card updateCard();
    void deleteCard();
}
