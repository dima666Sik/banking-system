package domain.models;

import java.util.Objects;

public class Phone {
    private final String phoneNumber;
    private final Money money;

    public Phone(String phoneNumber, Money money) {
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phoneNumber.equals(phone.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", moneyOnThePhone=" + money +
                '}';
    }
}
