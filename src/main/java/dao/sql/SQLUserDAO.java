package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.UserDAO;
import dao.sql.query.QueryUser;
import domain.models.Account;
import domain.models.User;

import java.sql.*;

public class SQLUserDAO implements UserDAO {

    @Override
    public User createUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryUser.createUser());
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getLogin());
                statement.setString(4, user.getPassword());
                statement.setInt(5, user.getSex());
            } catch (SQLException e) {
                throw new DAOException("Cannot create user.", e);
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
        return null;
    }

    @Override
    public User readUser(Account account) throws DAOException {
        User user = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.createStatement();
                try {
                    resultSet = statement.executeQuery("SELECT * FROM users");
                    while (resultSet.next()) {

                        String login_user = resultSet.getString(4);
                        String password_user = resultSet.getString(5);
                        if (account.getLogin().equals(login_user) && account.getPassword().equals(password_user)) {
                            int id = resultSet.getInt(1);
                            String first_name = resultSet.getString(2);
                            String last_name = resultSet.getString(3);
                            int sex = resultSet.getInt(6);

                            System.out.println("AUTHORIZATION SUCCESS");
                            user = new User(login_user.toCharArray(), password_user.toCharArray(), first_name, last_name, sex, null);
                            break;
                        }
                    }
                } finally {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                throw new DAOException("Cannot authorization.", e);
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
        return user;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
