package ui.swing;

import domain.iface.I_System;
import domain.models.Card;
import domain.models.Loan;
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

public class TakeOutLoanForm extends JDialog {
    private User user;
    private JComboBox comboBoxUserCards;
    private JTextField textFieldCurrency;
    private JTextField textFieldSum;
    private JButton backButton;
    private JButton takeButton;
    private JComboBox comboBoxPercent;
    private JComboBox comboBoxDeadline;
    private JTextField textFieldAmountWithPercent;
    private JPanel panelTakeALoan;
    private JButton calcButton;

    public TakeOutLoanForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelTakeALoan);
        setMinimumSize(new Dimension(600, 500));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = SwitchBox.setComboBoxListCards(user, comboBoxUserCards);
        comboBoxUserCards.addActionListener(e -> {
            if (comboBoxUserCards.getSelectedItem() != null) {
                List<Card> cardList = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCards.getSelectedItem()) && !card.getNumberCard().equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (cardList.size() != 0) {
                    textFieldCurrency.setText(String.valueOf(cardList.get(0).getMoney().getCurrency()));
                } else {
                    textFieldCurrency.setText("");
                }
            }
        });

        calcButton.addActionListener(e -> {
            if (!textFieldSum.getText().isEmpty() && !(comboBoxPercent.getSelectedItem()).equals("0")) {
                if(checkStringForNumber(textFieldSum.getText()))
                textFieldAmountWithPercent.setText(amountWithPercent(textFieldSum.getText(), (String) comboBoxPercent.getSelectedItem()));
            }
        });
        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });
        takeButton.addActionListener(e -> {
            if(checkStringForNumber(textFieldSum.getText()))
            credit();
        });

        setVisible(true);
    }

    private void credit() {
        if (!textFieldSum.getText().isEmpty() &&
                !(comboBoxPercent.getSelectedItem()).equals("0") &&
                !(comboBoxDeadline.getSelectedItem()).equals("0")
        ) {
            Loan loan = new Loan(new BigDecimal(textFieldSum.getText()),
                    new BigDecimal(amountWithPercent(textFieldSum.getText(), (String) comboBoxPercent.getSelectedItem())),
                    comboBoxPercent.getSelectedItem().toString(),
                    comboBoxDeadline.getSelectedItem().toString(),
                    textFieldCurrency.getText());
            user.setLoan(loan);
            I_System i_system = new SystemImpl(user);
            i_system.takeLoans((String) comboBoxUserCards.getSelectedItem());

        }
    }

    private String amountWithPercent(String sum, String percent) {
        return String.valueOf(Double.parseDouble(sum) + (Double.parseDouble(sum) * Double.parseDouble(percent)) / 100);
    }

    private boolean checkStringForNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "You enter string not number!",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
