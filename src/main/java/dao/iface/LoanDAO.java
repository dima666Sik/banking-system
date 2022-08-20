package dao.iface;

import domain.models.Loan;
import domain.models.User;

public interface LoanDAO {
    void createLoans(User user);

    void readLoans();

    void updateLoans();

    void deleteLoans();
}
