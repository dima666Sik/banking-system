package domain.models;

import java.util.Objects;

public class Card {
    private final long numberCard;
    private final int cardEndDataMonth;
    private final int cardEndDataYear;
    private final int CVC2;
    private final Money money;

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

    public Money getMoney() {
        return money;
    }

    public Card(long numberCard, int cardEndDataMonth, int cardEndDataYear, int CVC2, Money money) {
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
        return numberCard == card.numberCard && CVC2 == card.CVC2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberCard, CVC2);
    }
}
