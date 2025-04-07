package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {

    public static final int MAX_LENGTH = 85;
    public static final String MESSAGE_CONSTRAINTS = "Phone numbers must adhere to the following:\n"
            + "1. Must have at least 3 numbers \n"
            + String.format("2. Maximum of %d characters, includes spaces", MAX_LENGTH)
            + "Additional Information (Optional): "
            + "1. + at beginning for country code (e.g. +65, Please note that country code numbers will be counted in minimum"
            + "3. Optional label to follow after phone number, to be in a bracket with only alphanumeric characters"
            +  " e.g. (HP) \n";

    public static final String VALIDATION_REGEX = "^\\+?([\\d ]*\\d[\\d ]*\\d[\\d ]*\\d[\\d ]*)(\\([a-zA-Z0-9]*\\))?$";
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
