package ui.swing;

import domain.models.Card;
import domain.models.Phone;
import domain.models.User;
import ui.switchbox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowPhoneForm extends JDialog{
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;
    private JButton backButton;
    private JComboBox comboBoxUserPhones;
    private JPanel panelShowPhone;

    public ShowPhoneForm(User user) {
        setUndecorated(true);
        setContentPane(panelShowPhone);
        setMinimumSize(new Dimension(720, 200));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Phone> phones = SwitchBox.setComboBoxListPhone(user, comboBoxUserPhones);

        comboBoxUserPhones.addActionListener(e -> {
            if (comboBoxUserPhones.getSelectedItem() != null) {
                List<Phone> phoneList = phones.stream().
                        filter((phone) -> (phone.getPhoneNumber().equals(comboBoxUserPhones.getSelectedItem()) && !phone.getPhoneNumber().
                                equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (phoneList.size() != 0) {
                    textFieldMoney.setText(String.valueOf(phoneList.get(0).getMoney().getAmount()));
                    textFieldCurrency.setText(String.valueOf(phoneList.get(0).getMoney().getCurrency()));
                } else {
                    textFieldMoney.setText("");
                    textFieldCurrency.setText("");
                }
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });
        setVisible(true);
    }
}
