package dao.sql.query;

public class QueryMoney {
    public static String createTableMoneyForPhone() {
        return "create TABLE money_phone(\n" +
                "id_phone_money bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "    amount_phone bigint(10),\n" +
                "    currency_phone varchar(10),\n" +
                "    id_phone bigint(10) unsigned,\n" +
                "    PRIMARY KEY(id_phone_money),\n" +
                "    FOREIGN KEY (id_phone) REFERENCES phone (id_phone) on DELETE CASCADE on UPDATE CASCADE\n" +
                ");";
    }

    public static String createTableMoneyForCard() {
        return "create TABLE money_card(\n" +
                "id_card_money bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "    amount_card bigint(10),\n" +
                "    currency_card varchar(10),\n" +
                "    id_card bigint(10) unsigned,\n" +
                "    PRIMARY KEY(id_card_money),\n" +
                "    FOREIGN KEY (id_card) REFERENCES cards (id_card) on DELETE CASCADE on UPDATE CASCADE\n" +
                ");";
    }

    public static String createMoneyForPhone() {
        return "insert into money_phone (amount_phone, currency_phone, id_phone) values (?, ?, ?);";
    }

    public static String createMoneyForCard() {
        return "insert into money_card (amount_card, currency_card, id_card) values (?, ?, ?);";
    }
}
