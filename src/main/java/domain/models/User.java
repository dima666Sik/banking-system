package domain.models;

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
    private ArrayList<Phone> phoneArrayList;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSex() {
        return sex;
    }

    public char[] getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    public ArrayList<Phone> getPhoneArrayList() {
        return phoneArrayList;
    }

    public String getRole() {
        return role;
    }

    public User(String firstName, String lastName, int sex, char[] login, char[] password, ArrayList<Card> cardArrayList, ArrayList<Phone> phoneArrayList, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.login = login;
        this.password = password;
        this.cardArrayList = cardArrayList;
        this.phoneArrayList = phoneArrayList;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sex == user.sex && firstName.equals(user.firstName) && lastName.equals(user.lastName) && Arrays.equals(login, user.login) && Arrays.equals(password, user.password);
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
                ", role='" + role + '\'' +
                '}';
    }
}
