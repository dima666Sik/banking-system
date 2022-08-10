package dao.sql.query;

public class QueryPhone {
    public static String createTablePhone() {
        return "create table phone(\n" +
                "id_phone bigint(10) unsigned AUTO_INCREMENT NOT NULL,\n" +
                "phone_number varchar(60),\n" +
                "id_user bigint(10) unsigned\n" +
                "PRIMARY KEY(id_phone),\n" +
                "FOREIGN KEY (id_user)  REFERENCES users (id_user) on delete cascade on update cascade\n"+
                ");";
    }

    public static String createPhone() {
        return "insert into phone (phone_number,id_user) values (?,?);";
    }
}
