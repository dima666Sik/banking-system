package domain.iface;

import domain.models.Account;
import domain.models.Card;
import domain.models.Phone;
import domain.models.User;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface I_System {
    /** replenish yourself a card amount*/
    void replenishOnTheCard(String ownCard,String replenishAmount);
    /** replenish somebody a card amount*/
    boolean replenishOnTheCard(String ownCard, String rechargeableCard, BigDecimal replenishAmount);
    ArrayList<Card> returnListCardsUser();
    ArrayList<Phone> returnListPhoneUser();
    void withdrawingMoney(BigDecimal withdrawingAmount);
    /** replenish somebody a phone amount*/
    boolean replenishPhone(String numberCard, String phone, BigDecimal amount);

    /** temp method, add param ??? */
    default void utilityBill(BigDecimal replenishAmount){}
    default void takeOutLoan(){}

    /** registration user in system */
    void registration();
    void registrationCard();
    /** authorization user in system */
    User authorization(Account account);
}
