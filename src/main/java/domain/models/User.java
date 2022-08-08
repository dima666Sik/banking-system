package domain.models;

import domain.system.Generator;

import java.util.*;

public class User extends Account {
    private String firstName;
    private String lastName;
    /**
     * @value is 1 if sex is male else 0
     */
    private int sex;
    private ArrayList<Card> cardArrayList;
    private Phone phone;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSex() {
        return sex;
    }

    public ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    public void setCardArrayList(String card) {
        cardArrayList.add(new Card(Generator.generateNumberCard(),
                Generator.generateCardEndDataMonth(),
                Generator.generateCardEndDataYear(),
                Generator.generateCVC2(),
                phone.getMoneyOnThePhone())
        );
    }

    public User(char[] login, char[] password, String firstName, String lastName, int sex, Phone phone) {
        super(login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phone = phone;
        cardArrayList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sex == user.sex && firstName.equals(user.firstName) && lastName.equals(user.lastName) && phone.equals(user.phone) && Arrays.equals(super.getLogin(), user.getLogin()) && Arrays.equals(super.getPassword(), user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName, sex, cardArrayList, phone);
        result = 31 * result + Arrays.hashCode(super.getLogin());
        result = 31 * result + Arrays.hashCode(super.getPassword());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", login=" + Arrays.toString(super.getLogin()) +
                ", password=" + Arrays.toString(super.getPassword()) +
                ", cardArrayList=" + cardArrayList +
                ", phone=" + phone +
                '}';
    }
}
