package domain.models;

public class Account {
    private char[] login;
    private char[] password;

    public Account(char[] login, char[] password) {
        this.login = login;
        this.password = password;
    }

    public char[] getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setLogin(char[] login) {
        this.login = login;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
