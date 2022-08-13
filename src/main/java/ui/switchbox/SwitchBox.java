package ui.switchbox;

import domain.iface.I_System;
import domain.models.Card;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SwitchBox {
    public static ArrayList<Card> setComboBoxList(User user, JComboBox comboBoxUserCards) {
        I_System i_system = new SystemImpl(user);
        ArrayList<Card> cards = i_system.returnListCardsUser();

        Iterator<Card> iterator = cards.iterator();
        comboBoxUserCards.addItem("Your choose");
        while (iterator.hasNext()) {
            comboBoxUserCards.addItem(iterator.next().getNumberCard());
        }
        return cards;
    }
}
