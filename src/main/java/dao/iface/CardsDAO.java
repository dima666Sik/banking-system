package dao.iface;

import domain.models.Card;
import domain.models.User;

public interface CardsDAO{
    void createCard(User user);
    Card readCard();
    Card updateCard();
    void deleteCard();
}
