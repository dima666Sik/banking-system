package dao.sql;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SQLMoneyDAOTest {
    private final SQLMoneyDAO moneyDAO = new SQLMoneyDAO();

    @Test
    public void readMoneyFromCard() {
        Assert.assertEquals(Initialize.user.getCard().getMoney(), moneyDAO.readMoneyFromCard(SQLCheckID.checkIdCard(Initialize.user.getCard())));
    }

    @Test
    public void readMoneyFromPhone() {
        Assert.assertEquals(Initialize.user.getPhone().getMoney(), moneyDAO.readMoneyFromPhone(SQLCheckID.checkIdPhone(Initialize.user.getPhone())));
    }

    @Test
    public void createMoneyForPhone() {
        moneyDAO.createMoneyForPhone(Initialize.user);
    }

    @Test
    public void createMoneyForCard() {
        moneyDAO.createMoneyForCard(Initialize.user);
    }
}