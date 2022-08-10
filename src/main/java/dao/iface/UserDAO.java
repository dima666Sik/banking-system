package dao.iface;

import dao.exceptions.DAOException;
import domain.models.Account;
import domain.models.User;

public interface UserDAO {
    User createUser(User user) throws DAOException;
    User readUser(Account account) throws DAOException;
    User updateUser();
    void deleteUser();
}
