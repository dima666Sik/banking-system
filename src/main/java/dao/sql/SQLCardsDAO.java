package dao.sql;

import dao.controller.DBConnector;
import dao.iface.CardsDAO;
import dao.sql.query.QueryCards;
import dao.sql.query.QueryMoney;
import domain.models.Account;
import domain.models.Card;
import domain.models.Money;
import domain.models.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLCardsDAO implements CardsDAO {
    private final SQLMoneyDAO moneyDAO = new SQLMoneyDAO();

    @Override
    public boolean createCard(User user) {
        boolean flag = true;
        if (cardIsExist(user)) {
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
        } else {
            flag = false;
            JOptionPane.showMessageDialog(null,
                    "Such user is defined, please change login...",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    private boolean cardIsExist(User user) {
        boolean flag = true;
        System.out.println(user.getLogin());
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCards.selectCard());
        ) {
            statement.setString(1, user.getCard().getNumberCard());
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    flag = false;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Card readCard(String numberCard) {
        Card card = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCards.selectCard());
        ) {
            statement.setString(1, numberCard);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int idCard = resultSet.getInt("id_card");
                    card = new Card(resultSet.getString("number_card"),
                            resultSet.getString("card_end_data_month"),
                            resultSet.getString("card_end_data_year"),
                            resultSet.getString("cvc2"),
                            moneyDAO.readMoneyFromCard(idCard)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
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
                            moneyDAO.readMoneyFromCard(idCard)
                    ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    @Override
    public Card updateCard() {
        return null;
    }

    @Override
    public void deleteCard() {

    }
}
