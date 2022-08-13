package dao.sql.query;

public class QueryMoney {
    public static String createTableMoneyForPhone() {
        return "create TABLE money_phone(\n" +
                "id_phone_money bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "    amount_phone decimal(10,2),\n" +
                "    currency_phone varchar(10),\n" +
                "    id_phone bigint(10) unsigned,\n" +
                "    PRIMARY KEY(id_phone_money),\n" +
                "    FOREIGN KEY (id_phone) REFERENCES phone (id_phone) on DELETE CASCADE on UPDATE CASCADE\n" +
                ");";
    }

    public static String createTableMoneyForCard() {
        return "create TABLE money_card(\n" +
                "id_card_money bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "    amount_card decimal(10,2),\n" +
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

    public static String selectMoneyForCard() {
        return "select * from money_card where id_card in (?);";
    }

    public static String selectMoneyForPhone() {
        return "select * from money_phone where id_phone in (?);";
    }


    public static String updateMoneyForCard(){
        return "UPDATE money_card SET amount_card = (?) WHERE id_card = (?);";
    }
    public static String updateMoneyForPhone(){
        return "UPDATE money_phone SET amount_phone = (?) WHERE id_phone = (?);";
    }
}
