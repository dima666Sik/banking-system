package domain.env;

public enum Currency {
    USD("USD"),
    UAH("UAH"),
    EUR("EUR");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
