package dao.sql;

import dao.controller.DBConnector;
import dao.iface.MoneyDAO;
import dao.sql.query.QueryMoney;
import domain.models.Card;
import domain.models.Money;
import domain.models.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLMoneyDAO implements MoneyDAO {
    @Override
    public void createMoneyForPhone(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.createMoneyForPhone());
        ) {
            statement.setBigDecimal(1, user.getPhone().getMoney().getAmount());
            statement.setString(2, String.valueOf(user.getPhone().getMoney().getCurrency()));
            statement.setInt(3, SQLCheckID.checkIdPhone(user.getPhone()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMoneyForCard(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.createMoneyForCard());
        ) {
            statement.setBigDecimal(1, user.getCard().getMoney().getAmount());
            statement.setString(2, String.valueOf(user.getCard().getMoney().getCurrency()));
            statement.setInt(3, SQLCheckID.checkIdCard(user.getCard()));
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
    public void updateMoney(BigDecimal replenishAmount, Card card) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.updateMoneyForCard());
        ) {
            System.out.println("re:"+replenishAmount);
            statement.setBigDecimal(1, replenishAmount);
            statement.setInt(2, SQLCheckID.checkIdCard(card));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMoney() {

    }
}
