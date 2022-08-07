package domain.models;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private final BigDecimal amount;
    /** Currency */
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * @return Amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return Current currency
     */
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
