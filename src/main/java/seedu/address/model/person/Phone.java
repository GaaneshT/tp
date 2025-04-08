package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {

    public static final int MAX_LENGTH = 85;
    public static final String MESSAGE_CONSTRAINTS = "Each phone number must adhere to the following constraints:\n"
            + "1. Must contain at least 3 digits (only numbers and spaces, please use spaces in place of dashes).\n"
            + String.format("2. Total input must not exceed %d characters, including spaces.\n", MAX_LENGTH)
            + "3. Multiple phone numbers may be added, but must be separated by at least a space.\n"
            + "Optional Additions (per number):\n • A '+' may be added at the start to indicate a country code. \n"
            + "• An optional label may follow the number in round brackets, e.g. +65 8888 8888 (HP). "
            + "Only alphanumeric characters are allowed inside the brackets.\n";

    public static final String VALIDATION_REGEX = "^\\+?([\\d ]*\\d[\\d ]*\\d[\\d ]*\\d[\\d ]*)(\\([a-zA-Z0-9]*\\))"
            + "?(?:\\s+\\+?([\\d ]*\\d[\\d ]*\\d[\\d ]*\\d[\\d ]*)(\\([a-zA-Z0-9]*\\))?)*$";
    public final String value;

    /**
     * Constructs a {@code Phone}.
     *
     * @param phone A valid phone number.
     */
    public Phone(String phone) {
        requireNonNull(phone);
        checkArgument(isValidPhone(phone), MESSAGE_CONSTRAINTS);
        value = phone;
    }

    /**
     * Returns true if a given string is a valid phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(VALIDATION_REGEX) && isValidLength(test);
    }

    /**
     * Check length of email against limit
     * @param test
     * @return Returns true if given email exceeds max length
     */
    public static boolean isValidLength(String test) {
        return test.length() <= MAX_LENGTH;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Phone)) {
            return false;
        }

        Phone otherPhone = (Phone) other;
        return value.equals(otherPhone.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
