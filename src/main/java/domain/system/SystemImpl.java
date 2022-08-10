package domain.system;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.PhoneDAO;
import dao.iface.UserDAO;
import dao.sql.SQLPhoneDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.models.Account;
import domain.models.User;

import java.math.BigDecimal;
import java.sql.*;

public class SystemImpl implements I_System {
    User user;
    UserDAO userDAO;
    PhoneDAO phoneDAO;

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
        phoneDAO = new SQLPhoneDAO();
        try {
            userDAO.createUser(user);
            phoneDAO.createPhone(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User authorization(Account account) {
        userDAO = new SQLUserDAO();
        try {
            user = userDAO.readUser(account);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
