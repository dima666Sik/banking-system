package domain.system;

import dao.exceptions.DAOException;
import dao.iface.PhoneDAO;
import dao.iface.UserDAO;
import dao.sql.SQLPhoneDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.models.Account;
import domain.models.User;

import java.math.BigDecimal;

public class SystemImpl implements I_System {
    User user;
    UserDAO userDAO;
    PhoneDAO phoneDAO;

    public SystemImpl(User user) {
        this.user = user;
    }

    public SystemImpl() {
    }

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
        return null;
    }

}
