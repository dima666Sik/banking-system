package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.UserDAO;
import dao.sql.query.QueryUser;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {

    @Override
    public User createUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryUser.createUser());
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getLogin());
                statement.setString(4,user.getPassword());
                statement.setInt(5,user.getSex());
            } catch (SQLException e) {
                throw new DAOException("Cannot create user.", e);
            } finally {
                try {
                    statement.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User readUser() {
        return null;
    }

    @Override
    public User updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }
}
