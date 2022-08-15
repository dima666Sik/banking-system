package dao.sql;

import domain.models.Card;
import domain.models.Money;
import domain.models.Phone;
import domain.models.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public abstract class Initialize {
    public static final User user = new User("din", "qwerty", "Dimas", "Kuirin", 1);
    public static final ArrayList<Card> cardArrayList = new ArrayList<>();
    public static final ArrayList<Phone> phoneArrayList = new ArrayList<>();
    private static final Money money = new Money(new BigDecimal("0.00"), Currency.getInstance(Locale.US));

    static {
        phoneArrayList.add(new Phone("+380955677777",money));
        phoneArrayList.add(new Phone("+380955678888",money));
        user.setPhone(phoneArrayList.get(1));


        cardArrayList.add(new Card("5587393088834888", "8", "2022", "777", money));
        cardArrayList.add(new Card("5587393088834999", "8", "2022", "999", money));
        user.setCard(cardArrayList.get(0));
    }
}
