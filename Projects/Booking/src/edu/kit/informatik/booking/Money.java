package edu.kit.informatik.booking;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * A certain amount of money represented by its value and currency.
 * 
 * @author Philipp Merkle <programmieren-vorlesung@ipd.kit.edu>
 * 
 * @version 1.0
 *
 */
public class Money {

    /**
     * EUR currency (ISO Code 978)
     */
    public static final Currency EURO = Currency.getInstance("EUR");

    /**
     * USD currency (ISO Code 840)
     */
    public static final Currency DOLLAR = Currency.getInstance("USD");

    private BigDecimal value;

    private Currency currency;

    /**
     * Constructs the specified amount of money.
     * 
     * @param value
     *            the value
     * @param currency
     *            the currency
     */
    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    /**
     * @return the value of this money representation
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @return the currency of this money representation
     */
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return value + ";" + currency.getCurrencyCode();
    }

}
