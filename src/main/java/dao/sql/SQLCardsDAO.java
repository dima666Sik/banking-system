package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.CardsDAO;
import dao.sql.query.QueryCards;
import dao.sql.query.QueryUser;
import domain.models.Card;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLCardsDAO implements CardsDAO {
    @Override
    public void createCard(User user) throws DAOException {

    }

    @Override
    public Card readCard() {
        return null;
    }

    @Override
    public Card updateCard() {
        return null;
    }

    @Override
    public void deleteCard() {

    }
}
