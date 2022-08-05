package models;

import java.util.Objects;

public class Card {
    private long numberCard;
    private int cardEndDataMonth;
    private int cardEndDataYear;
    private int CVC2;

    public long getNumberCard() {
        return numberCard;
    }

    public int getCardEndDataMonth() {
        return cardEndDataMonth;
    }

    public int getCardEndDataYear() {
        return cardEndDataYear;
    }

    public int getCVC2() {
        return CVC2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return numberCard == card.numberCard && cardEndDataMonth == card.cardEndDataMonth && cardEndDataYear == card.cardEndDataYear && CVC2 == card.CVC2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, cardEndDataMonth, cardEndDataYear, CVC2);
    }

    @Override
    public String toString() {
        return "Card{" +
                "numberCard=" + numberCard +
                ", cardEndDataMonth=" + cardEndDataMonth +
                ", cardEndDataYear=" + cardEndDataYear +
                ", CVC2=" + CVC2 +
                '}';
    }
}
