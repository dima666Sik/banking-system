package dao.sql;

import dao.controller.DBConnector;
import dao.iface.LoanDAO;
import dao.sql.query.QueryLoans;
import domain.models.Loan;
import domain.models.User;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLLoanDAO implements LoanDAO {
    final static Logger logger = Logger.getLogger(FileReader.class);
    @Override
    public void createLoans(User user) {
        try (Connection connection = DBConnector.getConnector();
             PreparedStatement statement = connection.prepareStatement(QueryLoans.insertLoans());
        ) {
            statement.setBigDecimal(1, user.getLoan().getSumLoan());
            statement.setBigDecimal(2, user.getLoan().getRemainedLoan());
            statement.setString(3, user.getLoan().getPercentLoan());
            statement.setString(4, user.getLoan().getDeadlineLoan());
            statement.setString(5, user.getLoan().getCurrencyLoan());
            statement.setString(6, user.getLoan().getStartLoan());
            statement.setString(7, user.getLoan().getEndLoan());
            statement.setInt(8, SQLCheckID.checkIdUser(user));
            statement.executeUpdate();
            logger.info("Create loan was successful");
        } catch (SQLException e) {
            logger.error(e);
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
