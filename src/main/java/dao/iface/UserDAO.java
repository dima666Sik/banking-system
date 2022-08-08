package dao.iface;

import domain.models.User;

public interface UserDAO {
    User createUser();
    User readUser();
    User updateUser();
    void deleteUser();
}
