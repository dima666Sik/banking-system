package dao.sql;

import dao.controller.DBConnector;
import dao.sql.query.QueryCards;
import dao.sql.query.QueryPhone;
import dao.sql.query.QueryUser;
import domain.models.Account;
import domain.models.Card;
import domain.models.Phone;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLCheckID {

    public static int checkIdUser(Account account){
        int id = 0;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser());
        ) {
            statement.setString(1, account.getLogin());
            statement.setString(2, account.getPassword());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    id = resultSet.getInt("id_user");
                }
                if (id == 0) JOptionPane.showMessageDialog(null,
                        "First part registration user is fault... (user not found)",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int checkIdPhone(Phone phone){
        int id = 0;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.selectPhone());
        ) {
            statement.setString(1, phone.getPhoneNumber());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    id = resultSet.getInt("id_phone");
                }
                if (id == 0) JOptionPane.showMessageDialog(null,
                        "Phone not found.",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int checkIdCard(Card card){
        int id = 0;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryCards.selectCard());
        ) {
            statement.setString(1, card.getNumberCard());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    id = resultSet.getInt("id_card");
                }
                if (id == 0) JOptionPane.showMessageDialog(null,
                        "Card not found.",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
}
