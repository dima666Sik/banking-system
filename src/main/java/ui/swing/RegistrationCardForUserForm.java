package ui.swing;

import domain.iface.I_System;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;

public class RegistrationCardForUserForm extends JDialog {
    private final User user;
    private JTextField textFieldNumberCard;
    private JTextField textFieldMonthEndCard;
    private JTextField textFieldYearEndCard;
    private JTextField textFieldCVC2;
    private JButton nextButton;
    private JPanel panelRegistrationCard;

    public RegistrationCardForUserForm(User user) {
        this.user = user;
        this.user.setCard();
        setUndecorated(true);
        setContentPane(panelRegistrationCard);
        setMinimumSize(new Dimension(480, 420));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        textFieldNumberCard.setText(user.getCard().getNumberCard());
        textFieldMonthEndCard.setText(user.getCard().getCardEndDataMonth());
        textFieldYearEndCard.setText(user.getCard().getCardEndDataYear());
        textFieldCVC2.setText(user.getCard().getCVC2());

        nextButton.addActionListener(e -> {
            registrationCard();
        });

        setVisible(true);
    }

    private void registrationCard() {
        dispose();
        I_System i_system = new SystemImpl(user);

        if (i_system.registrationCard()) {
            dispose();
            new ActionMenuForm(user);
        }else{
            dispose();
            new RegistrationCardForUserForm(user);
        }
    }
}
