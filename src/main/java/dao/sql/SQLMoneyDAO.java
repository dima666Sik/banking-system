package dao.sql;

import dao.controller.DBConnector;
import dao.iface.MoneyDAO;
import dao.sql.query.QueryMoney;
import domain.models.Money;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLMoneyDAO implements MoneyDAO {
    @Override
    public void createMoney(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.createMoneyForPhone());
        ) {
            System.out.println(SQLCheckID.checkIdPhone(user.getPhone()));
            statement.setBigDecimal(1, user.getPhone().getMoneyOnThePhone().getAmount());
            statement.setString(2, String.valueOf(user.getPhone().getMoneyOnThePhone().getCurrency()));
            statement.setInt(3, SQLCheckID.checkIdPhone(user.getPhone()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
