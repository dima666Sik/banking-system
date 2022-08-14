package ui.swing;

import domain.models.Card;
import domain.models.User;
import domain.models.utility.TV;
import domain.models.utility.Utility;
import ui.switchbox.SwitchBox;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.env.EnvironmentUtilities.*;

public class PayOfUtilityForm extends JDialog {
    private JLabel fieldNameUtility;
    private User user;
    private Utility utility;
    private JTextField textFieldAmountUtility;
    private JComboBox comboBoxUserCards;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;
    private JPanel panelPayOfUtility;
    private JButton backButton;
    private JButton payButton;

    public PayOfUtilityForm(User user, Utility utility) {
        this.user = user;
        this.utility=utility;
        fieldNameUtility.setText(utility.getNameUtility());

        setUndecorated(true);
        setContentPane(panelPayOfUtility);
        setMinimumSize(new Dimension(960, 300));

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
        payButton.addActionListener(e -> {
            pay();
        });
        setVisible(true);
    }

    private void pay() {
        switch (utility.getEnvironmentUtilities()){
            case INTERNET:{
                //handle inet
                break;
            }
            case TV:{
                //handle tv
                break;
            }
            case GAS:{
                //handle gas
                break;
            }
            case WATER:{
                //handle water
                break;
            }
        }
    }
}
