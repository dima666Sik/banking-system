package domain.iface;

import domain.models.Account;
import domain.models.Card;
import domain.models.Phone;
import domain.models.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface I_System {
    /** replenish yourself a card amount*/
    boolean replenishOnTheCard(String ownCard,BigDecimal replenishAmount);
    /** replenish somebody a card amount*/
    boolean replenishOnTheCard(String ownCard, String rechargeableCard, BigDecimal replenishAmount);
    ArrayList<Card> returnListCardsUser();
    ArrayList<Phone> returnListPhoneUser();
    boolean withdrawingMoney(String ownCard, BigDecimal withdrawingAmount);
    /** replenish somebody a phone amount*/
    boolean replenishPhone(String numberCard, String phone, BigDecimal amount);

    /** temp method, add param ??? */
    default void utilityBill(BigDecimal replenishAmount){}
    default void takeOutLoan(){}
    boolean addPhone(String numberPhone);

    /** registration user in system */
    boolean registration();
    boolean registrationCard();
    /** authorization user in system */
    User authorization(Account account);
}
