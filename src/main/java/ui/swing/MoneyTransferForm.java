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


public class MoneyTransferForm extends JDialog {
    private User user;
    private JComboBox comboBoxUserCards;
    private JPanel panelReplenishmentCard;
    private JTextField textFieldSomebodyCard;
    private JTextField textFieldAmount;
    private JButton buttonReturnInMenu;
    private JButton replenishmentButton;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;

    public MoneyTransferForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelReplenishmentCard);
        setMinimumSize(new Dimension(860, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = SwitchBox.setComboBoxList(user, comboBoxUserCards);

        comboBoxUserCards.addActionListener(e -> {
            if (comboBoxUserCards.getSelectedItem() != null) {
                List<Card> cardList = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCards.getSelectedItem()) && !card.getNumberCard().
                                equals("Your choose"))).
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

        buttonReturnInMenu.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });
        replenishmentButton.addActionListener(e -> {
            replenishment();
        });
        setVisible(true);
    }

    private void replenishment() {
        I_System i_system = new SystemImpl(user);
        boolean flag = i_system.replenishOnTheCard((String) comboBoxUserCards.getSelectedItem(), textFieldSomebodyCard.getText(), new BigDecimal(textFieldAmount.getText()));
        if (flag) {
            dispose();
            new ActionMenuForm(user);
        }
    }
}
