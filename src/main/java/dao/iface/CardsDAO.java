package dao.iface;

import dao.exceptions.DAOException;
import domain.models.Card;
import domain.models.User;

public interface CardsDAO{
    void createCard(User user) throws DAOException;
    Card readCard();
    Card updateCard();
    void deleteCard();
}
