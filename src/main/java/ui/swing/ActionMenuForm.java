package ui.swing;

import domain.models.User;


import javax.swing.*;
import java.awt.*;

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

    public ActionMenuForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelActionMenu);
        setMinimumSize(new Dimension(720, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        replenishmentOfTheAccountButton.addActionListener(e -> {
            replenishmentOfTheAccount();
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

        });
        setVisible(true);
    }

    private void paymentOfUtilityService() {
    }

    private void replenishmentOfMobile() {
    }

    private void moneyTransfer() {
        dispose();
        System.out.println(user);
        new MoneyTransferForm(user);
    }

    private void opportunityToTakeOut() {
    }

    private void withdrawingMoney() {
    }

    private void replenishmentOfTheAccount() {
        dispose();
        System.out.println(user);
        new MoneyTransferForm(user);
    }
}
