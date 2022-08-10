package ui.swing;

import domain.iface.I_System;
import domain.models.Money;
import domain.models.Phone;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class RegistrationUserForm extends JDialog {
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldLogin;
    private JPasswordField passwordFieldPassword;
    private JButton registrationButton;
    private JButton cancelButton;
    private JButton signInButton;
    private JPanel panelRegistration;
    private JTextField textFieldPhone;
    private JComboBox comboBoxSex;
    private static final int DEFAULT_VALUE_MONEY_NEW_USER = 0;

    public RegistrationUserForm() {
        setUndecorated(true);
        setContentPane(panelRegistration);
        setMinimumSize(new Dimension(480, 380));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cancelButton.addActionListener(e -> dispose());

        signInButton.addActionListener(e -> {
            dispose();
            new AuthorizationForm();
        });

        registrationButton.addActionListener(e -> {
            registrationUser();
        });

        setVisible(true);
    }

    private void registrationUser() {
//        dispose();
        if (!textFieldFirstName.getText().isEmpty() &&
                !textFieldLastName.getText().isEmpty() &&
                !textFieldLogin.getText().isEmpty() &&
                !textFieldPhone.getText().isEmpty() &&
                passwordFieldPassword.getPassword().length != 0) {

            I_System i_system = new SystemImpl(
                    new User(textFieldLogin.getText().toCharArray(),
                            passwordFieldPassword.getPassword(),
                            textFieldFirstName.getText(),
                            textFieldLastName.getText(),
                            comboBoxSex.getSelectedIndex(),
                            new Phone(textFieldPhone.getText(),
                                    new Money(new BigDecimal(DEFAULT_VALUE_MONEY_NEW_USER),
                                            Currency.getInstance(Locale.US)
                                    )
                            )
                    ));

            i_system.registration();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Please fill all fields...",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
