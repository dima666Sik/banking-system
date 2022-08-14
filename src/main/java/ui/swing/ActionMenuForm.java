package ui.swing;

import domain.models.User;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionMenuForm extends JDialog{
    private User user;
    private JButton replenishmentOfTheAccountButton;
    private JButton withdrawingMoneyFromTheButton;
    private JButton exitButton;
    private JButton paymentOfUtilityServiceButton;
    private JButton moneyTransferButton;
    private JButton opportunityToTakeOutButton;
    private JButton replenishmentOfMobileButton;
    private JPanel panelActionMenu;
    private JButton createNewCardButton;
    private JButton checkAmountPhoneButton;
    private JButton checkAmountCardsButton;
    private JButton addAdditionPhoneButton;

    public ActionMenuForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelActionMenu);
        setMinimumSize(new Dimension(720, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        replenishmentOfTheAccountButton.addActionListener(e -> {
            terminal();
        });
        withdrawingMoneyFromTheButton.addActionListener(e -> {
            withdrawingMoney();
        });
        opportunityToTakeOutButton.addActionListener(e -> {
            opportunityToTakeOut();
        });
        moneyTransferButton.addActionListener(e -> {
            moneyTransfer();
        });
        replenishmentOfMobileButton.addActionListener(e -> {
            replenishmentOfMobile();
        });
        paymentOfUtilityServiceButton.addActionListener(e -> {
            paymentOfUtilityService();
        });
        exitButton.addActionListener(e -> {
            dispose();
            new AuthorizationForm();
        });
        createNewCardButton.addActionListener(e -> {
            createNewCard();
        });

        checkAmountCardsButton.addActionListener(e -> {
            checkAmountCards();
        });

        checkAmountPhoneButton.addActionListener(e -> {
           checkAmountPhone();
        });

        addAdditionPhoneButton.addActionListener(e -> {
            addAdditionPhone();
        });
        setVisible(true);
    }

    private void addAdditionPhone() {
        dispose();
        System.out.println(user);
        new AddAdditionPhoneForm(user);
    }

    private void createNewCard() {
        dispose();
        System.out.println(user);
        new RegistrationCardForUserForm(user);
    }

    private void checkAmountPhone() {
        dispose();
        System.out.println(user);
        new ShowPhoneForm(user);
    }

    private void checkAmountCards() {
        dispose();
        System.out.println(user);
        new ShowCardForm(user);
    }

    private void paymentOfUtilityService() {
        dispose();
        new MenuChooseUtilityServiceForm(user);
    }

    private void replenishmentOfMobile() {
        dispose();
        System.out.println(user);
        new ReplenishPhoneForm(user);
    }

    private void moneyTransfer() {
        dispose();
        System.out.println(user);
        new MoneyTransferForm(user);
    }

    private void opportunityToTakeOut() {
    }

    private void withdrawingMoney() {
        dispose();
        System.out.println(user);
        new WithdrawingMoneyForm(user);
    }

    private void terminal() {
        dispose();
        System.out.println(user);
        new TerminalForm(user);
    }
}
