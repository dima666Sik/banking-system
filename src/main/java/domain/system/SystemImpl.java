package domain.system;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.UserDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.models.Account;
import domain.models.User;

import java.math.BigDecimal;
import java.sql.*;

public class SystemImpl implements I_System {
    User user;
    UserDAO userDAO;

    public SystemImpl(User user) {
        this.user = user;
    }

    //<<<<<<< HEAD:src/main/java/domain/system/System.java
//=======
    public SystemImpl() {

    }

    //>>>>>>> e826e169b7db4198e4aefe8be28d1eddd21bd726:src/main/java/domain/system/SystemImpl.java
    @Override
    public void replenishOnTheCard(BigDecimal replenishAmount) {

    }

    @Override
    public void replenishOnTheCard(BigDecimal replenishAmount, long rechargeableCard) {

    }

    @Override
    public void withdrawingMoney(BigDecimal withdrawingAmount) {

    }

    @Override
    public void replenishPhone(BigDecimal replenishAmount) {

    }

    @Override
    public void replenishPhone(BigDecimal replenishAmount, long numberPhone) {

    }

    @Override
    public void registration() {
        System.out.println(user);
        userDAO = new SQLUserDAO();
        try {
            userDAO.createUser(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User authorization(Account account) throws SQLException, DAOException {

        System.out.println(account.getLogin());
        System.out.println(account.getPassword());

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM users");
                while (resultSet.next()) {

                    String login_user = resultSet.getString(4);
                    String password_user = resultSet.getString(5);
                   if(account.getLogin().equals(login_user) && account.getPassword().equals(password_user)){
                       int id = resultSet.getInt(1);
                       System.out.println(id);
                       System.out.println("AUTHORIZATION SUCCESS");
                       break;
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

        return null;
    }

}
