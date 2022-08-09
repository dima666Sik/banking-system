package dao.iface;

import dao.exceptions.DAOException;
import domain.models.User;

public interface UserDAO {
    User createUser(User user) throws DAOException;
    User readUser();
    User updateUser();
    void deleteUser();
}
