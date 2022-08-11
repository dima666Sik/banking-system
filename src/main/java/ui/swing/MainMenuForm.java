package ui.swing;

import domain.iface.I_System;
import domain.models.Account;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;

public class MainMenuForm extends JDialog{

    private JButton registrationButton;
    private JButton exitButton;
    private JButton authorizationButton;
    private JPanel panelMainMenu;

    public MainMenuForm() {
        setUndecorated(true);
        setContentPane(panelMainMenu);
        setMinimumSize(new Dimension(480, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        exitButton.addActionListener(e -> dispose());
        authorizationButton.addActionListener(e -> {
            dispose();
            new AuthorizationForm();
        });
        registrationButton.addActionListener(e -> {
            dispose();
            new RegistrationUserForm();
        });
        setVisible(true);
    }
}
