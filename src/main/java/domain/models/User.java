package domain.models;

import domain.system.Generator;

import java.math.BigDecimal;
import java.util.*;

public class User extends Account {
    private String firstName;
    private String lastName;
    /**
     * @value is 1 if sex is male else 0
     */
    private int sex;
    /**
     * get index 0 -> number card, index 1 -> end month, index 2 -> end year, index 3 -> cvc2
     */
    private Card card;

    private Phone phone;

    private ArrayList<Phone> phones;

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public User(String login, String password, String firstName, String lastName, int sex) {
        super(login,password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Card getCard() {
        return card;
    }

    public void setCard() {
        this.card = new Card(
                Generator.generateNumberCard(),
                Generator.generateCardEndDataMonth(),
                Generator.generateCardEndDataYear(),
                Generator.generateCVC2(),
                new Money(new BigDecimal(0), Currency.getInstance(Locale.US))
        );
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSex() {
        return sex;
    }

    public User(char[] login, char[] password, String firstName, String lastName, int sex, Phone phone) {
        super(login, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sex == user.sex && firstName.equals(user.firstName) && lastName.equals(user.lastName) && phone.equals(user.phone) && super.getLogin().equals(user.getLogin()) && super.getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex, phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", phone=" + phone +
                '}';
    }
}
