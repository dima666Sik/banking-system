package dao.sql;

import dao.controller.DBConnector;
import dao.iface.CardsDAO;
import dao.sql.query.QueryCards;
import dao.sql.query.QueryMoney;
import domain.models.Account;
import domain.models.Card;
import domain.models.Money;
import domain.models.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;

public class SQLCardsDAO implements CardsDAO {
    @Override
    public void createCard(User user) {
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
    public ArrayList<Card> readCards(User user) {
        ArrayList<Card> cards = new ArrayList<>();
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCards.selectCards());
        ) {
            statement.setInt(1, SQLCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int idCard = resultSet.getInt("id_card");
                    cards.add(new Card(resultSet.getString("number_card"),
                            resultSet.getString("card_end_data_month"),
                            resultSet.getString("card_end_data_year"),
                            resultSet.getString("cvc2"),
                            readMoneyFromCard(idCard, user)
                            ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    private Money readMoneyFromCard(int idCard, User user) {
        Money money = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.selectMoneyForCard());
        ) {
            statement.setInt(1, idCard);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    money = new Money(new BigDecimal(resultSet.getInt("amount_card")),
                            Currency.getInstance(resultSet.getString("currency_card")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public Card updateCard() {
        return null;
    }

    @Override
    public void deleteCard() {

    }
}
