package ui.swing;

import domain.iface.I_System;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;

public class AddAdditionPhoneForm extends JDialog {
    private User user;
    private JTextField textFieldNumberPhone;
    private JButton backButton;
    private JButton addButton;
    private JPanel panelAddAdditionPhone;

    public AddAdditionPhoneForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelAddAdditionPhone);
        setMinimumSize(new Dimension(560, 100));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });
        addButton.addActionListener(e -> {
            addPhone();
        });
        setVisible(true);
    }

    private void addPhone() {
        I_System i_system = new SystemImpl(user);
        if (i_system.addPhone(textFieldNumberPhone.getText())) {
            dispose();
            new ActionMenuForm(user);
        }
    }
}
