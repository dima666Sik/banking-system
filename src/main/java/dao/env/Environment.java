package dao.env;

public enum Environment {
    DB_URL("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11511110"),
    USERNAME("sql11511110"),
    PASSWORD("4PHJxg2RS1");

    private final String environmentValue;

    Environment(String environmentValue) {
        this.environmentValue = environmentValue;
    }

    public String getEnvironmentValue() {
        return environmentValue;
    }
}
