package dao.sql;

import dao.controller.DBConnector;
import dao.iface.MoneyDAO;
import dao.sql.query.QueryMoney;
import domain.models.Card;
import domain.models.Money;
import domain.models.Phone;
import domain.models.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

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
    public Money readMoneyFromCard(int idCard) {
        Money money = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.selectMoneyForCard());
        ) {
            statement.setInt(1, idCard);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    money = new Money(resultSet.getBigDecimal("amount_card"),
                            Currency.getInstance(resultSet.getString("currency_card")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public Money readMoneyFromPhone(int idPhone) {
        Money money = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.selectMoneyForPhone());
        ) {
            statement.setInt(1, idPhone);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    money = new Money(resultSet.getBigDecimal("amount_phone"),
                            Currency.getInstance(resultSet.getString("currency_phone")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return money;
    }

    @Override
    public void updateMoney(BigDecimal replenishAmount, Card card) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.updateMoneyForCard());
        ) {
            statement.setBigDecimal(1, replenishAmount);
            statement.setInt(2, SQLCheckID.checkIdCard(card));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMoney(BigDecimal replenishAmount, Phone phone) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.updateMoneyForPhone());
        ) {
            statement.setBigDecimal(1, replenishAmount);
            statement.setInt(2, SQLCheckID.checkIdPhone(phone));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMoney() {

    }
}
