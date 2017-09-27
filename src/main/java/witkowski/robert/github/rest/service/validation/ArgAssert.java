package witkowski.robert.github.rest.service.validation;

/**
 * Simple arguments validation. Instead this we could annotation validations (for example @NonNull)
 */
public class ArgAssert {

    public static void isNotBlank(String text) {
        if (text == null || text.isEmpty()) {
            throw new ArgAssertException("String is blank!");
        }
    }
}
