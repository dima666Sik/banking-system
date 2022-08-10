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

    public static String createMoneyForPhone() {
        return "insert into money_phone (amount_phone, currency_phone, id_phone) values (?, ?, ?);";
    }
}
