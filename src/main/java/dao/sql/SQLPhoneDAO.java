package dao.sql;

import dao.controller.DBConnector;
import dao.iface.PhoneDAO;
import dao.sql.query.QueryPhone;
import domain.models.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SQLPhoneDAO implements PhoneDAO {
    private final SQLMoneyDAO moneyDAO = new SQLMoneyDAO();

    @Override
    public boolean createPhone(User user) {
        boolean flag = true;
        if (readPhone(user.getPhone().getPhoneNumber())==null) {
            try (Connection connection = DBConnector.getConnector();
                 PreparedStatement statement = connection.prepareStatement(QueryPhone.createPhone());
            ) {
                statement.setString(1, user.getPhone().getPhoneNumber());
                statement.setInt(2, SQLCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            flag = false;
            JOptionPane.showMessageDialog(null,
                    "Phone is exist",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
        return flag;
    }

    @Override
    public Phone readPhone(String phoneNumber) {
        Phone phone = null;
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.selectPhone());
        ) {
            statement.setString(1, phoneNumber);
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int idPhone = resultSet.getInt("id_phone");
                    phone = new Phone(resultSet.getString("phone_number"),
                            moneyDAO.readMoneyFromPhone(idPhone)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public Phone updatePhone() {
        return null;
    }

    @Override
    public void deletePhone() {

    }

    @Override
    public ArrayList<Phone> readPhones(User user) {
        ArrayList<Phone> phones = new ArrayList<>();
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryPhone.selectPhones());
        ) {
            statement.setInt(1, SQLCheckID.checkIdUser(new Account(user.getLogin(), user.getPassword())));
            try (ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int idPhone = resultSet.getInt("id_phone");
                    phones.add(new Phone(resultSet.getString("phone_number"),
                            moneyDAO.readMoneyFromPhone(idPhone)
                    ));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phones;
    }
}
