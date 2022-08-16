package dao.sql.query;

public class QueryLoans {
    public static String createTableLoans() {
        return "create table loan(\n" +
                "   id_loan bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "   sum_loan decimal(10,2),\n" +
                "   remained decimal(10,2),\n" +
                "   percent_loan varchar(10),\n" +
                "   deadline_loan varchar(10),\n" +
                "   currency_loan varchar(10),\n" +
                "   start_loan varchar(10),\n" +
                "   end_loan varchar(10),\n" +
                "   PRIMARY KEY(id_loan),\n" +
                "   FOREIGN KEY (id_user)  REFERENCES users (id_user) on DELETE CASCADE on UPDATE CASCADE\n" +
                ");";
    }

    public static String insertLoans() {
        return "insert into loan (sum_loan, remained_loan, percent_loan, deadline_loan, currency_loan, start_loan, end_loan, id_user) values(?,?,?,?,?,?,?,?);";
    }

    public static String selectLoans() {
        return "";
    }

    public static String updateLoans() {
        return "";
    }

    public static String deleteLoans() {
        return "";
    }

}
