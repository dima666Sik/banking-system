package dao.sql;

import dao.controller.DBConnector;
import dao.iface.CardsDAO;
import dao.sql.query.QueryCards;
import domain.models.Account;
import domain.models.Card;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQLCardsDAO implements CardsDAO {
    @Override
    public void createCard(User user){
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCards.createCards());
        ) {
            statement.setString(1, user.getCard().getNumberCard());
            statement.setString(2, user.getCard().getCardEndDataMonth());
            statement.setString(3, user.getCard().getCardEndDataYear());
            statement.setString(4, user.getCard().getCVC2());
            statement.setInt(5, SQLCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
