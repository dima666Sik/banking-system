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
    public void createUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryUser.createUser());
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getLogin());
                statement.setString(4, user.getPassword());
                statement.setInt(5, user.getSex());
                statement.executeUpdate();
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
    }

    @Override
    public User readUser(Account account) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryUser.selectUser());
                statement.setString(1, account.getLogin());
                statement.setString(2, account.getPassword());

                try {
                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        String first_name = resultSet.getString("first_name");
                        String last_name = resultSet.getString("last_name");
                        String login_user = resultSet.getString("login_user");
                        String password_user = resultSet.getString("password_user");
                        int sex = resultSet.getInt("sex");
                        user = new User(login_user.toCharArray(), password_user.toCharArray(), first_name, last_name, sex, null);
                    }
                    System.out.println(user);
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
