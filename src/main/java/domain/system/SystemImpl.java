package domain.system;

import dao.iface.CardsDAO;
import dao.iface.MoneyDAO;
import dao.iface.PhoneDAO;
import dao.iface.UserDAO;
import dao.sql.SQLCardsDAO;
import dao.sql.SQLMoneyDAO;
import dao.sql.SQLPhoneDAO;
import dao.sql.SQLUserDAO;
import domain.iface.I_System;
import domain.models.Account;
import domain.models.User;

import javax.swing.*;
import java.math.BigDecimal;

public class SystemImpl implements I_System {
    private User user;
    private UserDAO userDAO;
    private PhoneDAO phoneDAO;
    private MoneyDAO moneyDAO;
    private CardsDAO cardsDAO;

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
        moneyDAO = new SQLMoneyDAO();

        userDAO.createUser(user);
        phoneDAO.createPhone(user);
        moneyDAO.createMoneyForPhone(user);

    }

    @Override
    public void registrationCard() {
        cardsDAO = new SQLCardsDAO();
        moneyDAO = new SQLMoneyDAO();

        cardsDAO.createCard(user);
        moneyDAO.createMoneyForCard(user);

        System.out.println("E.N.D.");
    }

    @Override
    public User authorization(Account account) {
        userDAO = new SQLUserDAO();
        user = userDAO.readUser(account);
        if (user != null) {
            System.out.println("User successful authorization!");
            return user;
        } else {
            JOptionPane.showMessageDialog(null,
                    "User not defined!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
