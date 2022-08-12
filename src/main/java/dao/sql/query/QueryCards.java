package dao.sql.query;

public class QueryCards {
    public static String createTableCards() {
        return "create table cards(\n" +
                "id_card bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "    number_card varchar(16),\n" +
                "    card_end_data_month int(2),\n" +
                "    card_end_data_year int(4),\n" +
                "    cvc2 varchar(3),\n" +
                "    id_user bigint(10) unsigned,\n" +
                "    PRIMARY KEY(id_card),\n" +
                "    FOREIGN KEY (id_user)  REFERENCES users (id_user) on DELETE CASCADE on UPDATE CASCADE\n" +
                ");";
    }

    public static String createCards() {
        return "insert into cards (number_card,card_end_data_month,card_end_data_year,cvc2,id_user) values (?,?,?,?,?);";
    }

    public static String selectCard() {
        return "select * from cards where number_card in (?);";
    }

    public static String selectCards() {
        return "select * from cards where id_user in (?);";
    }
}
