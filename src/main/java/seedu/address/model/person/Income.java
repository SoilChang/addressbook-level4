package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * Represents a Person's value in the address book
 * Guarantees: immutable; is valid as declare in {@link #isValidIncome(float)}}
 */
public class Income {
    public static final String MESSAGE_INCOME_CONSTRAINTS =
            "Person value must be positive numerical numbers, floating point value";

    public final Double value;

    /**
     * @param value a valid value
     */
    public Income(Double value) {
        requireNonNull(value);
        checkArgument(this.isValidIncome(value), this.MESSAGE_INCOME_CONSTRAINTS);
        this.value = value;
    }


    public static boolean isValidIncome(Double income) {
        return (income >= 0);
    }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(this.value);
    }


    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Income
                && this.value == ((Income) other).value);
    }

}
