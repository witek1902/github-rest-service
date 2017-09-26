package witkowski.robert.github.rest.service.validation;

/**
 * Simple arguments validation. Instead this we could annotation validations (for example @NonNull)
 */
public class ArgAssert {

    public static void isNotBlank(String text) {
        if (text == null || "".equals(text)) {
            throw new ArgAssertException("String is blank!");
        }
    }

    public static void isNotBlank(String... texts) {
        for (int i = 0; i < texts.length; i++) {
            isNotBlank(texts[i]);
        }
    }
}
