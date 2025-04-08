package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Phone(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new Phone(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Phone.isValidPhone(null));

        // invalid phone numbers
        assertFalse(Phone.isValidPhone("")); // empty string
        assertFalse(Phone.isValidPhone(" ")); // space
        assertFalse(Phone.isValidPhone("12")); // less than 3 digits
        assertFalse(Phone.isValidPhone("+")); // no digits
        assertFalse(Phone.isValidPhone("()")); // brackets only
        assertFalse(Phone.isValidPhone("+()")); // country code and brackets only
        assertFalse(Phone.isValidPhone("12()")); // invalid phone number with brackets
        assertFalse(Phone.isValidPhone("+12()")); // invalid phone number with country code and brackets
        assertFalse(Phone.isValidPhone("123!")); // special character
        assertFalse(Phone.isValidPhone("+123#")); // special character
        assertFalse(Phone.isValidPhone("#123")); // wrong symbol for country code
        assertFalse(Phone.isValidPhone("123 (abc!)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("123 (abc@123)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("123 ()()")); // multiple brackets
        assertFalse(Phone.isValidPhone("123 (abc)123")); // extra after bracket
        assertFalse(Phone.isValidPhone("abc123")); // letters outside bracket
        assertFalse(Phone.isValidPhone("+1a2b3")); // letters outside bracket
        assertFalse(Phone.isValidPhone("123 ()abc")); // extra after bracket
        assertFalse(Phone.isValidPhone("(abc)")); // no digits at all
        assertFalse(Phone.isValidPhone("123 [abc]")); // wrong brackets
        assertFalse(Phone.isValidPhone("123 (abc123")); // missing closing bracket
        assertFalse(Phone.isValidPhone("123 abc123)")); // missing opening bracket
        assertFalse(Phone.isValidPhone("1 2")); // only 2 digits
        assertFalse(Phone.isValidPhone("+1 2")); // only 2 digits
        assertFalse(Phone.isValidPhone("12 34 (abc!)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("+(abc)")); // no digits at all
        assertFalse(Phone.isValidPhone("++123")); // double plus
        assertFalse(Phone.isValidPhone("")); // empty input
        assertFalse(Phone.isValidPhone("123-456")); // dash not allowed
        assertFalse(Phone.isValidPhone("123456789012345678901234567890123456789012345678901234567890"
                + "12345678901234567890123456")); //86 characters, exceed limit

        // multiple invalid phone numbers
        assertFalse(Phone.isValidPhone("+ +")); // no digits
        assertFalse(Phone.isValidPhone("() ()")); // brackets only
        assertFalse(Phone.isValidPhone("+() +()")); // country code and brackets only
        assertFalse(Phone.isValidPhone("12() 12()")); // invalid phone number with brackets
        assertFalse(Phone.isValidPhone("+12() +12()")); // invalid phone number with country code and brackets
        assertFalse(Phone.isValidPhone("123! 123!")); // special character
        assertFalse(Phone.isValidPhone("+123# +123#")); // special character
        assertFalse(Phone.isValidPhone("#123 ")); // wrong symbol for country code
        assertFalse(Phone.isValidPhone("123 (abc!) 123 (abc!)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("123 (abc@123) 123 (abc@123)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("123 ()() 123 ()()")); // multiple brackets
        assertFalse(Phone.isValidPhone("123 (abc)123 123 (abc)123")); // extra after bracket
        assertFalse(Phone.isValidPhone("abc123 abc123")); // letters outside bracket
        assertFalse(Phone.isValidPhone("+1a2b3 +1a2b3")); // letters outside bracket
        assertFalse(Phone.isValidPhone("123 ()abc 123 ()abc")); // extra after bracket
        assertFalse(Phone.isValidPhone("(abc) (abc)")); // no digits at all
        assertFalse(Phone.isValidPhone("123 [abc] 123 [abc]")); // wrong brackets
        assertFalse(Phone.isValidPhone("123 (abc123 123 (abc123")); // missing closing bracket
        assertFalse(Phone.isValidPhone("123 abc123) 123 abc123)")); // missing opening bracket
        assertFalse(Phone.isValidPhone("+1 2 +1 2")); // only 2 digits
        assertFalse(Phone.isValidPhone("12 34 (abc!) 12 34 (abc!)")); // invalid char in bracket
        assertFalse(Phone.isValidPhone("+(abc) +(abc)")); // no digits at all
        assertFalse(Phone.isValidPhone("++123 ++123")); // double plus
        assertFalse(Phone.isValidPhone("123-456 123-456")); // dash not allowed

        // invalid spacing
        assertFalse(Phone.isValidPhone("+123/+123"));
        assertFalse(Phone.isValidPhone("+123+123"));
        assertFalse(Phone.isValidPhone("+123+123+123+123+123+123+123+123+123"));
        assertFalse(Phone.isValidPhone("+1 2 3+1 2 3"));
        assertFalse(Phone.isValidPhone("+1 2 3-+1 2 3"));

        // valid phone numbers
        assertTrue(Phone.isValidPhone("+123")); // valid phone number with country code
        assertTrue(Phone.isValidPhone("123")); // valid phone number
        assertTrue(Phone.isValidPhone("1 2 3"));
        assertTrue(Phone.isValidPhone("+1 2 3"));
        assertTrue(Phone.isValidPhone("123 (abc)")); // valid phone number with label
        assertTrue(Phone.isValidPhone("123456 (abc123)"));
        assertTrue(Phone.isValidPhone("+123 456 789 (abcDEF)")); //valid phone number with country code and label
        assertTrue(Phone.isValidPhone("+ 1 2 3"));
        assertTrue(Phone.isValidPhone(" 1 2 3 "));
        assertTrue(Phone.isValidPhone("123 ()")); // empty label
        assertTrue(Phone.isValidPhone("+1234567890"));
        assertTrue(Phone.isValidPhone("123 456 7890"));
        assertTrue(Phone.isValidPhone("+1 2 3 (info123)"));
        assertTrue(Phone.isValidPhone("1 2 3(info)"));
        assertTrue(Phone.isValidPhone("123(info)"));
        assertTrue(Phone.isValidPhone("12345678901234567890"));
        assertTrue(Phone.isValidPhone("123 (A1B2C3)"));
        assertTrue(Phone.isValidPhone("+12 34 56 (user123)"));
        assertTrue(Phone.isValidPhone("+ 12 34 (A1B2C3)"));
        assertTrue(Phone.isValidPhone("123 (abcDEF123)"));

        // Multiple phone numbers
        assertTrue(Phone.isValidPhone("+123 +123")); // valid phone numbers with country code
        assertTrue(Phone.isValidPhone("123 123")); // valid phone numbers
        assertTrue(Phone.isValidPhone("1 2 3 1 2 3"));
        assertTrue(Phone.isValidPhone("+1 2 3 +1 2 3"));
        assertTrue(Phone.isValidPhone("123 (abc) 123 (abc)")); // valid phone number with label
        assertTrue(Phone.isValidPhone("123456 (abc123) 123456 (abc123)"));
        assertTrue(Phone.isValidPhone("+123 456(abcDEF) +123 456(abcDEF)")); //valid numbers with code and label
        assertTrue(Phone.isValidPhone("+ 1 2 3 + 1 2 3"));
        assertTrue(Phone.isValidPhone(" 1 2 3   1 2 3 "));
        assertTrue(Phone.isValidPhone("123 () 123 ()")); // empty label
        assertTrue(Phone.isValidPhone("+1234567890 +1234567890"));
        assertTrue(Phone.isValidPhone("123 456 7890 123 456 7890"));
        assertTrue(Phone.isValidPhone("+1 2 3 (info123) +1 2 3 (info123)"));
        assertTrue(Phone.isValidPhone("1 2 3(info) 1 2 3(info)"));
        assertTrue(Phone.isValidPhone("123(info) 123(info)"));
        assertTrue(Phone.isValidPhone("12345678901234567890 12345678901234567890"));
        assertTrue(Phone.isValidPhone("123 (A1B2C3) 123 (A1B2C3)"));
        assertTrue(Phone.isValidPhone("+12 34 56 (user123) +12 34 56 (user123)"));
        assertTrue(Phone.isValidPhone("+ 12 34 (A1B2C3) + 12 34 (A1B2C3)"));
        assertTrue(Phone.isValidPhone("123 (abcDEF123) 123 (abcDEF123)"));

        assertTrue(Phone.isValidPhone("123456789012345678901234567890123456789012345678901234567890"
                + "1234567890123456789012345")); // 85 characters, max limit
    }

    @Test
    public void equals() {
        Phone phone = new Phone("999");

        // same values -> returns true
        assertTrue(phone.equals(new Phone("999")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different values -> returns false
        assertFalse(phone.equals(new Phone("995")));
    }
}
