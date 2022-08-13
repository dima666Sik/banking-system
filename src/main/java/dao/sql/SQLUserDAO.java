package dao.sql;

import dao.controller.DBConnector;
import dao.iface.UserDAO;
import dao.sql.query.QueryUser;
import domain.models.Account;
import domain.models.Card;
import domain.models.Phone;
import domain.models.User;

import java.sql.*;
import java.util.ArrayList;


public class SQLUserDAO implements UserDAO {

    @Override
    public void createUser(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.createUser());
        ) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getSex());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUser(Account account) {
        User user = null;

        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser());
        ) {
            statement.setString(1, account.getLogin());
            statement.setString(2, account.getPassword());
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    String first_name = resultSet.getString("first_name");
                    String last_name = resultSet.getString("last_name");
                    String login_user = resultSet.getString("login_user");
                    String password_user = resultSet.getString("password_user");
                    int sex = resultSet.getInt("sex");
                    user = new User(login_user,
                            password_user,
                            first_name,
                            last_name,
                            sex);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
