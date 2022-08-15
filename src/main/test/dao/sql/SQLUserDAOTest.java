package dao.sql;

import domain.models.Account;
import junit.framework.TestCase;

public class SQLUserDAOTest extends TestCase {
    private final SQLUserDAO sqlUserDAO = new SQLUserDAO();

    public void testCreateUser() {
        assertTrue("must be true, user is exist.", sqlUserDAO.createUser(Initialize.user));
    }

    public void testReadUser() {
        assertEquals("must not null.", Initialize.user, sqlUserDAO.
                readUser(new Account(Initialize.user.getLogin(), Initialize.user.getPassword())));
    }
}