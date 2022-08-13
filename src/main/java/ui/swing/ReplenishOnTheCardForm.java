package ui.swing;

import domain.iface.I_System;
import domain.models.Card;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class ReplenishOnTheCardForm extends JDialog{
    private User user;
    private JComboBox comboBoxUserCards;
    private JPanel panelReplenishmentCard;
    private JTextField textFieldSomebodyCard;
    private JTextField textFieldAmount;
    private JButton buttonReturnInMenu;
    private JButton replenishmentButton;
    private JTextField textFieldMoney;
    private JTextField textFieldCurrency;

    private ArrayList<Card> setComboBoxList(){
        I_System i_system = new SystemImpl(user);
        ArrayList<Card> cards = i_system.returnListCardsUser();

        Iterator<Card> iterator = cards.iterator();
        comboBoxUserCards.addItem("Your choose");
        while (iterator.hasNext()){
            comboBoxUserCards.addItem(iterator.next().getNumberCard());
        }
        return cards;
    }

    public ReplenishOnTheCardForm(User user) {
        this.user = user;
        setUndecorated(true);
        setContentPane(panelReplenishmentCard);
        setMinimumSize(new Dimension(720, 300));

        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ArrayList<Card> cards = setComboBoxList();

        comboBoxUserCards.addActionListener(e -> {
            if (comboBoxUserCards.getSelectedItem() != null) {
                List<Card> cardList = cards.stream().
                        filter((card) -> (card.getNumberCard().equals(comboBoxUserCards.getSelectedItem())&&!card.getNumberCard().equals("Your choose"))).
                        peek(System.out::println).collect(Collectors.toList());
                if(cardList.size()!=0) {
                    textFieldMoney.setText(String.valueOf(cardList.get(0).getMoney().getAmount()));
                    textFieldCurrency.setText(String.valueOf(cardList.get(0).getMoney().getCurrency()));
                }else{
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
        System.out.println(textFieldAmount.getText());
        System.out.println(Double.parseDouble(textFieldAmount.getText()));
        System.out.println(BigDecimal.valueOf(Double.parseDouble(textFieldAmount.getText())));
        boolean flag = i_system.replenishOnTheCard((String) comboBoxUserCards.getSelectedItem(),textFieldSomebodyCard.getText(),textFieldAmount.getText());
        if(flag){
            dispose();
            new ActionMenuForm(user);
        }
    }
}
