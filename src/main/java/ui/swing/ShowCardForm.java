package ui.swing;

import domain.models.Card;
import domain.models.User;
import ui.switchbox.SwitchBox;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowCardForm extends JDialog{
    private JComboBox comboBoxUserCards;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;
    private JButton backButton;
    private JPanel panelShowCard;

    public ShowCardForm(User user) {
        setUndecorated(true);
        setContentPane(panelShowCard);
        setMinimumSize(new Dimension(720, 200));

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
        setVisible(true);
    }

}
