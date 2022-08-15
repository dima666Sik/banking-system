package dao.iface;

import domain.models.Card;
import domain.models.Money;
import domain.models.Phone;
import domain.models.User;

import java.math.BigDecimal;

public interface MoneyDAO {
    void createMoneyForPhone(User user);
    void createMoneyForCard(User user);
    Money readMoneyFromCard(int idCard);
    public Money readMoneyFromPhone(int idPhone);
    void updateMoney(BigDecimal replenishAmount, Card card);
    void updateMoney(BigDecimal replenishAmount, Phone phone);
    void deleteMoney();
}
