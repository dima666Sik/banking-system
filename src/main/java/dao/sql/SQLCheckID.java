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

    public int checkIdUser(Account account) throws DAOException {
        int id = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        System.out.println(account.getLogin());
        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryUser.selectUser());
                System.out.println(statement);
                statement.setString(4, account.getLogin());
                statement.setString(5, account.getPassword());

                try {
                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        id = resultSet.getInt("id_user");
                        System.out.println(id);
                    }
                    if (id == 0) JOptionPane.showMessageDialog(null,
                            "First part registration user is fault... (user not found)",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                throw new DAOException("Cannot find id user.", e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
}