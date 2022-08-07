package domain.models;

import java.util.Objects;

public class Phone {
    private final String phoneNumber;
    private final Money moneyOnThePhone;

    public Phone(String phoneNumber, Money moneyOnThePhone) {
        this.phoneNumber = phoneNumber;
        this.moneyOnThePhone = moneyOnThePhone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Money getMoneyOnThePhone() {
        return moneyOnThePhone;
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
}
