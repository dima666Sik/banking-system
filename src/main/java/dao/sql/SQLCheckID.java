package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.sql.query.QueryUser;
import domain.models.Account;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLCheckID {

    public static int checkIdUser(Account account){
        int id = 0;
        System.out.println(account.getLogin());
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser());
        ) {
            System.out.println(statement);
            statement.setString(4, account.getLogin());
            statement.setString(5, account.getPassword());
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    id = resultSet.getInt("id_user");
                    System.out.println(id);
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
}
