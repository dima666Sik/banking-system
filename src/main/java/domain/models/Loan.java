package domain.models;

import domain.system.Generator;

import java.math.BigDecimal;

public class Loan {
    private final BigDecimal sumLoan;
    private final BigDecimal remainedLoan;
    private final String percentLoan;
    private final String deadlineLoan;
    private final String currencyLoan;
    private final String startLoan;
    private final String endLoan;

    public Loan(BigDecimal sumLoan, BigDecimal remainedLoan, String percentLoan, String deadlineLoan, String currencyLoan) {
        this.sumLoan = sumLoan;
        this.remainedLoan = remainedLoan;
        this.percentLoan = percentLoan;
        this.deadlineLoan = deadlineLoan;
        this.currencyLoan = currencyLoan;
        this.startLoan = Generator.generateData(0);
        this.endLoan = Generator.generateData(Integer.parseInt(deadlineLoan));
    }

    public BigDecimal getSumLoan() {
        return sumLoan;
    }

    public BigDecimal getRemainedLoan() {
        return remainedLoan;
    }

    public String getPercentLoan() {
        return percentLoan;
    }

    public String getDeadlineLoan() {
        return deadlineLoan;
    }

    public String getCurrencyLoan() {
        return currencyLoan;
    }

    public String getStartLoan() {
        return startLoan;
    }

    public String getEndLoan() {
        return endLoan;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "sumLoan=" + sumLoan +
                ", remainedLoan=" + remainedLoan +
                ", percentLoan=" + percentLoan +
                ", deadlineLoan=" + deadlineLoan +
                ", currencyLoan='" + currencyLoan + '\'' +
                ", startLoan='" + startLoan + '\'' +
                ", endLoan='" + endLoan + '\'' +
                '}';
    }
}
