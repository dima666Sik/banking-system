package dao.sql;

import dao.controller.DBConnector;
import dao.iface.LoanDAO;
import dao.sql.query.QueryLoans;
import domain.models.Loan;
import domain.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLLoanDAO implements LoanDAO {
    @Override
    public void createLoans(Loan loan, User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryLoans.insertLoans());
        ) {
            statement.setBigDecimal(1, loan.getSumLoan());
            statement.setBigDecimal(2, loan.getRemainedLoan());
            statement.setString(3, loan.getPercentLoan());
            statement.setString(4, loan.getDeadlineLoan());
            statement.setString(5, loan.getCurrencyLoan());
            statement.setString(6, loan.getStartLoan());
            statement.setString(7, loan.getEndLoan());
            statement.setInt(8, SQLCheckID.checkIdUser(user));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readLoans() {

    }

    @Override
    public void updateLoans() {

    }

    @Override
    public void deleteLoans() {

    }
}
