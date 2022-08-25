package ui.swing;

import domain.exceptions.DomainException;
import domain.models.Card;
import domain.models.Money;
import domain.models.User;
import domain.system.Generator;
import ui.switchbox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShowCardForm extends JDialog{
    private JComboBox comboBoxUserCards;
    private JTextField textFieldMoney;
    private JButton backButton;
    private JPanel panelShowCard;
    private JComboBox comboBoxCurrency;

    public ShowCardForm(User user) {
        setUndecorated(true);
        setContentPane(panelShowCard);
        setMinimumSize(new Dimension(720, 200));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = SwitchBox.setComboBoxListCards(user, comboBoxUserCards);
        final List<Card>[] cardList = new List[]{null};

        comboBoxUserCards.addActionListener(e -> {
            if (comboBoxUserCards.getSelectedItem() != null) {
                cardList[0] = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCards.getSelectedItem()) && !card.getNumberCard().
                                equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if (cardList[0].size() != 0) {
                    textFieldMoney.setText(String.valueOf(cardList[0].get(0).getMoney().getAmount()));
                    comboBoxCurrency.setSelectedItem(String.valueOf(cardList[0].get(0).getMoney().getCurrency()));
                } else {
                    textFieldMoney.setText("");
                    comboBoxCurrency.setSelectedIndex(0);
                }
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new ActionMenuForm(user);
        });

        comboBoxCurrency.addActionListener(e -> {
            try {
                textFieldMoney.setText(String.valueOf(Generator.generateCurrencyAmount(cardList[0].get(0).getMoney(),(String) Objects.requireNonNull(comboBoxCurrency.getSelectedItem()))));
            } catch (DomainException ex) {
                ex.printStackTrace();
            }
        });
        setVisible(true);
    }

}
