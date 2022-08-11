package ui.swing;

import domain.iface.I_System;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;

public class ActionMenuForm extends JDialog{
    private JButton replenishmentOfTheAccountButton;
    private JButton withdrawingMoneyFromTheButton;
    private JButton exitButton;
    private JButton paymentOfUtilityServiceButton;
    private JButton moneyTransferButton;
    private JButton opportunityToTakeOutButton;
    private JButton replenishmentOfMobileButton;
    private JPanel panelActionMenu;

    public ActionMenuForm() {
        setUndecorated(true);
        setContentPane(panelActionMenu);
        setMinimumSize(new Dimension(480, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        replenishmentOfTheAccountButton.addActionListener(e -> {
            replenishmentOfTheAccount();
        });
        withdrawingMoneyFromTheButton.addActionListener(e -> {

        });
        opportunityToTakeOutButton.addActionListener(e -> {

        });
        moneyTransferButton.addActionListener(e -> {

        });
        replenishmentOfMobileButton.addActionListener(e -> {

        });
        paymentOfUtilityServiceButton.addActionListener(e -> {

        });
        exitButton.addActionListener(e -> {

        });
        setVisible(true);
    }

    private void replenishmentOfTheAccount() {
        I_System i_system = new SystemImpl();
    }
}
