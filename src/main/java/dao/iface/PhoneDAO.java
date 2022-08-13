package dao.iface;

import domain.models.Phone;
import domain.models.User;

import java.util.ArrayList;

public interface PhoneDAO {
    void createPhone(User user);
    Phone readPhone(String phone);
    Phone updatePhone();
    void deletePhone();

    ArrayList<Phone> readPhones(User user);
}
