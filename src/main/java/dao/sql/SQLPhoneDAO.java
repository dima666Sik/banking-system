package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.PhoneDAO;
import dao.sql.query.QueryPhone;
import domain.models.Account;
import domain.models.Phone;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLPhoneDAO implements PhoneDAO {

    @Override
    public void createPhone(User user) throws DAOException {
        SQLCheckID sqlCheckID = new SQLCheckID();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryPhone.createPhone());
                statement.setString(1, user.getPhone().getPhoneNumber());
                statement.setInt(2, sqlCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Cannot create phone.", e);
            }
            finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
