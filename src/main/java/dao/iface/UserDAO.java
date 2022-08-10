package dao.iface;

import domain.models.Account;
import domain.models.User;

public interface UserDAO {
    void createUser(User user);
    User readUser(Account account);
    User updateUser();
    void deleteUser();
}
