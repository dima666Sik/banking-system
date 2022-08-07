package ui.swing;

import domain.iface.I_System;
import domain.system.System;

import javax.swing.*;
import java.awt.*;

public class RegistrationUserForm extends JDialog{
    private JFrame jParentFrame;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldSex;
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldPassword;
    private JButton registrationButton;
    private JButton cancelButton;
    private JButton signInButton;
    private JPanel panelRegistration;
    private JTextField textFieldPhone;

    public RegistrationUserForm() {
        setUndecorated(true);
        setContentPane(panelRegistration);
        setMinimumSize(new Dimension(480, 380));
        setModal(true);
        setLocationRelativeTo(jParentFrame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelButton.addActionListener(e -> dispose());

        signInButton.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        registrationButton.addActionListener(e -> {
            registrationUser();
        });

        setVisible(true);
    }

    private void registrationUser() {
    }
}
