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
import java.util.List;
import java.util.stream.Collectors;

public class TerminalForm extends JDialog{
    private User user;
    private JComboBox comboBoxUserCards;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;
    private JTextField textFieldDepositedMoney;
    private JButton backButton;
    private JButton replenishButton;
    private JPanel panelTerminal;
    private JComboBox comboBoxDepositedCurrency;

    public TerminalForm(User user) {
        this.user=user;
        setUndecorated(true);
        setContentPane(panelTerminal);
        setMinimumSize(new Dimension(820, 200));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = SwitchBox.setComboBoxListCards(user, comboBoxUserCards);

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

        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });

        replenishButton.addActionListener(e -> {
            replenish();
        });
        setVisible(true);
    }

    private void replenish() {
        I_System i_system = new SystemImpl(user);
        boolean flag = i_system.replenishOnTheCard((String) comboBoxUserCards.getSelectedItem(),new BigDecimal(textFieldDepositedMoney.getText()));
        if (flag) {
            dispose();
            new ActionMenuForm(user);
        }
    }

}
