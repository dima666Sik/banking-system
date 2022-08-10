package dao.sql;

import dao.controller.DBConnector;
import dao.iface.PhoneDAO;
import dao.sql.query.QueryPhone;
import domain.models.Account;
import domain.models.Phone;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQLPhoneDAO implements PhoneDAO {

    @Override
    public void createPhone(User user){
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.createPhone());
        ) {
            statement.setString(1, user.getPhone().getPhoneNumber());
            statement.setInt(2, SQLCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Phone readPhone() {
        return null;
    }

    @Override
    public Phone updatePhone() {
        return null;
    }

    @Override
    public void deletePhone() {

    }
}
