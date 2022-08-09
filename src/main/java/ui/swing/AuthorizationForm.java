package ui.swing;

import domain.iface.I_System;
import domain.models.Account;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;

public class AuthorizationForm extends JDialog {
    private JFrame jFrameOld;
    private JPanel panelSignIn;
    private JTextField loginField;
    private JButton authorizationButton;
    private JButton registrationButton;
    private JPasswordField passwordField;
    private JButton closeButton;

    public AuthorizationForm() {
        setUndecorated(true);
        setContentPane(panelSignIn);
        setMinimumSize(new Dimension(480, 350));

        setModal(true);
        setLocationRelativeTo(jFrameOld);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(e -> dispose());
        authorizationButton.addActionListener(e -> {
//            dispose();
            I_System i_system = new SystemImpl();
            i_system.authorization(new Account(loginField.getText().toCharArray(), passwordField.getPassword()));
        });
        registrationButton.addActionListener(e -> {
            dispose();
            new RegistrationUserForm();
        });
        setVisible(true);
    }

}
