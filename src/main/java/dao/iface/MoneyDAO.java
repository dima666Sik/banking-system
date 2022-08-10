package dao.iface;

import dao.exceptions.DAOException;
import domain.models.Money;
import domain.models.User;

public interface MoneyDAO {
    void createMoney(User user) throws DAOException;
    Money readMoney();
    Money updateMoney();
    void deleteMoney();
}
