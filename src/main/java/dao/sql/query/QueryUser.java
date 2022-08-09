package dao.sql.query;

public class QueryUser {

    public static String createTableUser() {
        return "create table users(\n" +
                "   id_user bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "   first_name varchar(60),\n" +
                "   last_name varchar(60),\n" +
                "   login_user varchar(120),\n" +
                "   password_user varchar(120),\n" +
                "   sex tinyint(2),\n" +
                "   PRIMARY KEY(id_user)\n" +
                ");";
    }

    public static String isTableUser() {
        return "show tables like \"users\";";
    }

    public static String createUser() {
        return "insert into users (first_name, last_name, sex, phone) values (?,?,?,?);";
    }

    public  static String selectUser(){
        return "select * from users where login_user in (?) and password_user in (?);";
    }

}
