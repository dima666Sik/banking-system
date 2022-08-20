package dao.sql;

import dao.controller.DBConnector;
import dao.iface.MoneyDAO;
import dao.sql.query.QueryMoney;
import domain.models.Card;
import domain.models.Money;
import domain.models.Phone;
import domain.models.User;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

public class SQLMoneyDAO implements MoneyDAO {
    final static Logger logger = Logger.getLogger(FileReader.class);

    @Override
    public void createMoneyForPhone(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryMoney.createMoneyForPhone());
        ) {
            statement.setBigDecimal(1, user.getPhone().getMoney().getAmount());
            statement.setString(2, String.valueOf(user.getPhone().getMoney().getCurrency()));
            statement.setInt(3, SQLCheckID.checkIdPhone(user.getPhone()));
            statement.executeUpdate();
            logger.info("Create money for phone was successful!");
        } catch (SQLException e) {
            logger.error(e);
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
            logger.info("Create money for card was successful!");
        } catch (SQLException e) {
            logger.error(e);
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
                logger.info("Read money from phone was successful!");
            }
        } catch (SQLException e) {
            logger.error(e);
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
                logger.info("Read money from card was successful!");
            }
        } catch (SQLException e) {
            logger.error(e);
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
            logger.info("Update money for card was successful!");
        } catch (SQLException e) {
            logger.error(e);
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
            logger.info("Update money for phone was successful!");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void deleteMoney() {

    }
}
