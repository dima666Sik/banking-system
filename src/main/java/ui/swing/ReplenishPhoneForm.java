package ui.swing;

import domain.iface.I_System;
import domain.models.Card;
import domain.models.User;
import domain.system.SystemImpl;
import ui.switchbox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ReplenishPhoneForm extends JDialog {

    private JPanel panelReplenishMobil;
    private JTextField phoneField;
    private JTextField sumField;
    private JButton exitButton;
    private JButton replenishmentButton;
    private JComboBox comboBoxUserCards;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;
    private User user;

    public ReplenishPhoneForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelReplenishMobil);
        setMinimumSize(new Dimension(660, 400));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        exitButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });

        ArrayList<Card> cards = SwitchBox.setComboBoxListCards(user, comboBoxUserCards);

        comboBoxUserCards.addActionListener(e -> {
            if (comboBoxUserCards.getSelectedItem() != null) {
                List<Card> cardList = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCards.getSelectedItem()) && !card.getNumberCard().equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (cardList.size() != 0) {
                    textFieldMoney.setText(String.valueOf(cardList.get(0).getMoney().getAmount()));
                    textFieldCurrency.setText(String.valueOf(cardList.get(0).getMoney().getCurrency()));
                } else {
                    textFieldMoney.setText("");
                    textFieldCurrency.setText("");
                }
            }
        });
        replenishmentButton.addActionListener(e -> {
            replenishment();
        });
        setVisible(true);
    }

    public void replenishment() {
        I_System i_system = new SystemImpl(user);
        boolean flag = i_system.replenishPhone((String) comboBoxUserCards.getSelectedItem(),
                phoneField.getText(),
                new BigDecimal(sumField.getText()));
        if (flag) {
            dispose();
            new ActionMenuForm(user);
        }
    }

}
