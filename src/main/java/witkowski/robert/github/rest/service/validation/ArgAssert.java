package witkowski.robert.github.rest.service.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Simple arguments validation. Instead this we could annotation validations (for example @NonNull)
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArgAssert {

    public static void isNotBlank(String text) {
        if (text == null || text.isEmpty()) {
            throw new ArgAssertException("String is blank!");
        }
    }
}
