package dao.sql;

import dao.controller.DBConnector;
import dao.iface.PhoneDAO;
import dao.sql.query.QueryMoney;
import dao.sql.query.QueryPhone;
import domain.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

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
    public Phone readPhone(String phoneNumber) {
        Phone phone = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.selectPhoneWithPhoneNumber());
        ) {
            statement.setString(1, phoneNumber);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int idPhone = resultSet.getInt("id_phone");
                    phone = new Phone(resultSet.getString("phone_number"),
                            readMoneyFromPhone(idPhone)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phone;
    }

    private Money readMoneyFromPhone(int idPhone) {
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
    public Phone updatePhone() {
        return null;
    }

    @Override
    public void deletePhone() {

    }
}
