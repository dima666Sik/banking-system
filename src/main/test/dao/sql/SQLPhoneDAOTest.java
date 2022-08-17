package dao.sql;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SQLPhoneDAOTest {
    private final SQLPhoneDAO sqlPhoneDAO = new SQLPhoneDAO();

    @Test
    public void createPhone() {
        assertTrue(sqlPhoneDAO.createPhone(Initialize.user));
    }

    @Test
    public void readPhone() {
        Assert.assertEquals(Initialize.user.getPhone(), sqlPhoneDAO.readPhone(Initialize.user.getPhone().getPhoneNumber()));
    }

    @Test
    public void readPhones() {
        Assert.assertEquals(Initialize.phoneArrayList, sqlPhoneDAO.readPhones(Initialize.user));
    }
}