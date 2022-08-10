package dao.sql;

import dao.controller.DBConnector;
import dao.exceptions.DAOException;
import dao.iface.MoneyDAO;
import dao.sql.query.QueryMoney;
import dao.sql.query.QueryUser;
import domain.models.Money;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLMoneyDAO implements MoneyDAO {
    @Override
    public void createMoney(User user) throws DAOException {
        DBConnector dbConnector = null;
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DBConnector.getConnector();
            try {
                statement = connection.prepareStatement(QueryMoney.createMoneyForPhone());
                statement.setBigDecimal(1,user.getPhone().getMoneyOnThePhone().getAmount());
                statement.setString(2, String.valueOf(user.getPhone().getMoneyOnThePhone().getCurrency()));
                statement.executeUpdate();
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
    }

    @Override
    public Money readMoney() {
        return null;
    }

    @Override
    public Money updateMoney() {
        return null;
    }

    @Override
    public void deleteMoney() {

    }
}
