package dao.sql;

import org.junit.Assert;
import org.junit.Test;

public class SQLCardsDAOTest {
    private final SQLCardsDAO sqlCardsDAO = new SQLCardsDAO();

    @Test
    public void createCard() {
        Assert.assertTrue(sqlCardsDAO.createCard(Initialize.user));
    }

    @Test
    public void readCard() {
        Assert.assertEquals(Initialize.user.getCard(), sqlCardsDAO.readCard(Initialize.user.getCard().getNumberCard()));
    }

    @Test
    public void readCards() {
        Assert.assertEquals(Initialize.cardArrayList, sqlCardsDAO.readCards(Initialize.user));
    }
}