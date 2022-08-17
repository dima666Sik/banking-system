package ui.switchbox;

import domain.iface.I_System;
import domain.models.Card;
import domain.models.Phone;
import domain.models.User;
import domain.system.SystemImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SwitchBox {
    public static ArrayList<Card> setComboBoxListCards(User user, JComboBox comboBoxUserCards) {
        I_System i_system = new SystemImpl(user);
        ArrayList<Card> cards = i_system.returnListCardsUser();

        Iterator<Card> iterator = cards.iterator();
        comboBoxUserCards.addItem("Your choose");
        while (iterator.hasNext()) {
            comboBoxUserCards.addItem(iterator.next().getNumberCard());
        }
        return cards;
    }

    public static ArrayList<Phone> setComboBoxListPhone(User user, JComboBox comboBoxUserCards) {
        I_System i_system = new SystemImpl(user);
        ArrayList<Phone> phones = i_system.returnListPhoneUser();

        Iterator<Phone> iterator = phones.iterator();
        comboBoxUserCards.addItem("Your choose");
        while (iterator.hasNext()) {
            comboBoxUserCards.addItem(iterator.next().getPhoneNumber());
        }
        return phones;
    }
}
