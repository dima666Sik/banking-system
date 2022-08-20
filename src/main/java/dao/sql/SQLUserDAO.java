package dao.sql;

import dao.controller.DBConnector;
import dao.iface.UserDAO;
import dao.sql.query.QueryUser;
import domain.models.Account;

import domain.models.User;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.FileReader;
import java.sql.*;


public class SQLUserDAO implements UserDAO {
    final static Logger logger = Logger.getLogger(FileReader.class);

    @Override
    public boolean createUser(User user) {
        boolean flag = true;
        if (userIsExist(user)) {
            try (Connection connection = DBConnector.getConnector();
                 PreparedStatement statement = connection.prepareStatement(QueryUser.createUser());
            ) {
                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getLogin());
                statement.setString(4, user.getPassword());
                statement.setInt(5, user.getSex());
                statement.executeUpdate();
                logger.info("Create user was successful!");
            } catch (SQLException e) {
                logger.error(e);
            }
        }else{
            flag=false;
            JOptionPane.showMessageDialog(null,
                    "Such user is defined, please change login...",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    private boolean userIsExist(User user) {
        boolean flag = true;
        System.out.println(user.getLogin());
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryUser.selectUser());
        ) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    flag = false;
                    break;
                }
                logger.info("Check user exist was successful!");
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return flag;
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
                logger.info("Read user was successful!");
            }
        } catch (SQLException e) {
            logger.error(e);
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
