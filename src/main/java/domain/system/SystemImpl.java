package domain.system;

import dao.iface.*;
import dao.sql.*;
import domain.iface.I_System;
import domain.models.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class SystemImpl implements I_System {
    private User user;
    private UserDAO userDAO;
    private PhoneDAO phoneDAO;
    private MoneyDAO moneyDAO;
    private CardsDAO cardsDAO;
    private LoanDAO loanDAO;

    public SystemImpl(User user) {
        this.user = user;
    }

    public SystemImpl() {

    }

    @Override
    public boolean replenishOnTheCard(String ownCard, BigDecimal replenishAmount) {
        boolean flag = false;
        CardsDAO cardsDAO = new SQLCardsDAO();
        MoneyDAO moneyDAO = new SQLMoneyDAO();

        Card own = cardsDAO.readCard(ownCard);

        if (own == null) {
            JOptionPane.showMessageDialog(null,
                    "The own card not found.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            BigDecimal resOwnAmount = own.getMoney().getAmount().
                    add(replenishAmount);
            moneyDAO.updateMoney(resOwnAmount, own);
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean replenishOnTheCard(String ownCard, String rechargeableCard, BigDecimal replenishAmount) {
        boolean flag = false;
        CardsDAO cardsDAO = new SQLCardsDAO();
        MoneyDAO moneyDAO = new SQLMoneyDAO();

        Card own = cardsDAO.readCard(ownCard);
        Card rechargeable = cardsDAO.readCard(rechargeableCard);

        if (own == null) {
            JOptionPane.showMessageDialog(null,
                    "The own card not found.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (rechargeable != null) {
            BigDecimal resOwnAmount = own.getMoney().getAmount().subtract(replenishAmount);
            if (resOwnAmount.compareTo(BigDecimal.ZERO) >= 0) {
                BigDecimal resRechargeableAmount = rechargeable.getMoney().getAmount().
                        add(replenishAmount);
                moneyDAO.updateMoney(resOwnAmount, own);
                moneyDAO.updateMoney(resRechargeableAmount, rechargeable);
                flag = true;
            } else JOptionPane.showMessageDialog(null,
                    "The senders money account is less than the amount sent.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,
                "The rechargeable card not found.",
                "Try again",
                JOptionPane.ERROR_MESSAGE);
        return flag;
    }

    @Override
    public ArrayList<Card> returnListCardsUser() {
        cardsDAO = new SQLCardsDAO();

        return cardsDAO.readCards(user);
    }

    @Override
    public ArrayList<Phone> returnListPhoneUser() {
        phoneDAO = new SQLPhoneDAO();

        return phoneDAO.readPhones(user);
    }

    @Override
    public boolean withdrawingMoney(String ownCard, BigDecimal withdrawingAmount) {
        boolean flag = false;
        CardsDAO cardsDAO = new SQLCardsDAO();
        MoneyDAO moneyDAO = new SQLMoneyDAO();

        Card own = cardsDAO.readCard(ownCard);

        if (own == null) {
            JOptionPane.showMessageDialog(null,
                    "The own card not found.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            BigDecimal resOwnAmount = own.getMoney().getAmount().
                    subtract(withdrawingAmount);
            moneyDAO.updateMoney(resOwnAmount, own);
            flag = true;
        }
        return flag;
    }


    @Override
    public boolean replenishPhone(String numberCard, String phoneNumber, BigDecimal amount) {
        boolean flag = false;
        CardsDAO cardsDAO = new SQLCardsDAO();
        PhoneDAO phoneDAO = new SQLPhoneDAO();
        MoneyDAO moneyDAO = new SQLMoneyDAO();

        Card card = cardsDAO.readCard(numberCard);
        Phone phone = phoneDAO.readPhone(phoneNumber);

        if (card == null) {
            JOptionPane.showMessageDialog(null,
                    "The card not found.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (phone != null) {
            BigDecimal resOwnAmount = card.getMoney().getAmount().
                    subtract(amount);
            System.out.println(resOwnAmount);
            if (resOwnAmount.compareTo(BigDecimal.ZERO) >= 0) {
                BigDecimal resIncreaseInPhoneAmount = phone.getMoney().getAmount().
                        add(amount);
                moneyDAO.updateMoney(resOwnAmount, card);
                moneyDAO.updateMoney(resIncreaseInPhoneAmount, phone);
                flag = true;
            } else JOptionPane.showMessageDialog(null,
                    "The senders money account is less than the amount sent.",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,
                "The phone not found.",
                "Try again",
                JOptionPane.ERROR_MESSAGE);
        return flag;
    }

    @Override
    public boolean addPhone(String numberPhone) {
        phoneDAO = new SQLPhoneDAO();
        moneyDAO = new SQLMoneyDAO();
        user.setPhone(new Phone(numberPhone, new Money(new BigDecimal(0), Currency.getInstance(Locale.US))));
        boolean flag = phoneDAO.createPhone(user);
        if (flag) {
            moneyDAO.createMoneyForPhone(user);
        }
        return flag;
    }


    @Override
    public boolean takeLoans(String numberCard) {
        userDAO = new SQLUserDAO();
        cardsDAO = new SQLCardsDAO();
        loanDAO = new SQLLoanDAO();
        moneyDAO = new SQLMoneyDAO();

        Card card = cardsDAO.readCard(numberCard);

        if (loanDAO.createLoans(user) && card != null) {
            BigDecimal resRechargeableAmount = card.getMoney().getAmount().
                    add(user.getLoan().getSumLoan());
            moneyDAO.updateMoney(resRechargeableAmount, card);
            return true;
        } else return false;
    }

    @Override

    public boolean registration() {
        System.out.println(user);

        userDAO = new SQLUserDAO();
        phoneDAO = new SQLPhoneDAO();
        moneyDAO = new SQLMoneyDAO();

        boolean flag = userDAO.createUser(user);

        if (flag) {
            phoneDAO.createPhone(user);
            moneyDAO.createMoneyForPhone(user);
        }
        return flag;
    }

    @Override
    public boolean registrationCard() {
        cardsDAO = new SQLCardsDAO();
        moneyDAO = new SQLMoneyDAO();

        boolean flag = cardsDAO.createCard(user);
        if (flag) {
            moneyDAO.createMoneyForCard(user);
        }
        return flag;
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
