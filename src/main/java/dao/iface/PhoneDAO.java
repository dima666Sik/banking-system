package dao.iface;

import dao.exceptions.DAOException;
import domain.models.Phone;
import domain.models.User;

public interface PhoneDAO {
    void createPhone(User user);
    Phone readPhone();
    Phone updatePhone();
    void deletePhone();
}
