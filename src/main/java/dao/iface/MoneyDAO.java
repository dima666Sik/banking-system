package dao.iface;

import domain.models.Money;
import domain.models.User;

public interface MoneyDAO {
    void createMoney(User user);
    Money readMoney();
    Money updateMoney();
    void deleteMoney();
}
