package ru.yuzhakov.shop.webclient.models;

import java.math.BigDecimal;

/**
 * Объект с данными для транзакции.
 */
public class Transaction {
    private Long creditNumber;
    private Long debitNumber;
    private BigDecimal sum;

    public Transaction(Long creditNumber, Long debitNumber, BigDecimal sum) {
        this.creditNumber = creditNumber;
        this.debitNumber = debitNumber;
        this.sum = sum;
    }

    public Transaction() {
    }

    public Long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Long getDebitNumber() {
        return debitNumber;
    }

    public void setDebitNumber(Long debitNumber) {
        this.debitNumber = debitNumber;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
