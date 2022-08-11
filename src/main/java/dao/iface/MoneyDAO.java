package dao.iface;

import domain.models.Money;
import domain.models.User;

public interface MoneyDAO {
    void createMoneyForPhone(User user);
    void createMoneyForCard(User user);
    Money readMoney();
    Money updateMoney();
    void deleteMoney();
}
