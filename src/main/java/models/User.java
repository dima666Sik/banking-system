package models;

import ifaces.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    /**
     * @value is 1 if sex is male else 0
     * */
    private int sex;
    private char[] login;
    private char[] password;
    private ArrayList<Card> cardArrayList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sex == user.sex && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Arrays.equals(login, user.login) && Arrays.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, sex);
        result = 31 * result + Arrays.hashCode(login);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", login=" + Arrays.toString(login) +
                ", password=" + Arrays.toString(password) +
                ", cardArrayList=" + cardArrayList +
                '}';
    }
}
