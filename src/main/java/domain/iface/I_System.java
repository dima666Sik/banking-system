package domain.iface;

import domain.models.Account;
import domain.models.User;

import java.math.BigDecimal;

public interface I_System {
    /** replenish yourself a card amount*/
    void replenishOnTheCard(BigDecimal replenishAmount);
    /** replenish somebody a card amount*/
    void replenishOnTheCard(BigDecimal replenishAmount, long rechargeableCard);
    void withdrawingMoney(BigDecimal withdrawingAmount);
    /** replenish yourself a phone amount*/
    void replenishPhone(BigDecimal replenishAmount);
    /** replenish somebody a phone amount*/
    void replenishPhone(BigDecimal replenishAmount, long numberPhone);

    /** temp method, add param ??? */
    default void utilityBill(BigDecimal replenishAmount){}
    default void takeOutLoan(){}

    /** registration user in system */
    void registration();
    void registrationCard();
    /** authorization user in system */
    User authorization(Account account);
}
