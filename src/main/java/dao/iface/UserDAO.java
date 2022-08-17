package dao.iface;

import domain.models.Account;
import domain.models.User;

public interface UserDAO {
    boolean createUser(User user);
    User readUser(Account account);
    User updateUser();
    void deleteUser();
}
