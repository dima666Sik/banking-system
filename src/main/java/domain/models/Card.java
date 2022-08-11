package domain.models;

import java.util.Objects;

public class Card {
    public static char FIRST_NUMBER_PAYMENT_SYSTEM_MASTER_CARD = '5';
    private final String numberCard;
    private final String cardEndDataMonth;
    private final String cardEndDataYear;
    private final String CVC2;
    private final Money money;

    public String getNumberCard() {
        return numberCard;
    }

    public String getCardEndDataMonth() {
        return cardEndDataMonth;
    }

    public String getCardEndDataYear() {
        return cardEndDataYear;
    }

    public String getCVC2() {
        return CVC2;
    }

    public Money getMoney() {
        return money;
    }

    public Card(String numberCard, String cardEndDataMonth, String cardEndDataYear, String CVC2, Money money) {
        this.numberCard = numberCard;
        this.cardEndDataMonth = cardEndDataMonth;
        this.cardEndDataYear = cardEndDataYear;
        this.CVC2 = CVC2;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(numberCard, card.numberCard) && Objects.equals(CVC2, card.CVC2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, CVC2);
    }

    @Override
    public String toString() {
        return "Card{" +
                "numberCard='" + numberCard + '\'' +
                ", cardEndDataMonth='" + cardEndDataMonth + '\'' +
                ", cardEndDataYear='" + cardEndDataYear + '\'' +
                ", CVC2='" + CVC2 + '\'' +
                ", money=" + money +
                '}';
    }
}
