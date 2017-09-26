package witkowski.robert.github.rest.service.integration.github;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import witkowski.robert.github.rest.service.integration.common.PropertyKeys;
import witkowski.robert.github.rest.service.integration.common.PropertyProvider;
import witkowski.robert.github.rest.service.validation.ArgAssert;

import java.util.Map;

/**
 * This is implementation of PropertyProvider which return property saved in static Map for GitHub
 */
@Component
class GitHubPropertyProvider implements PropertyProvider {

    private final static Map<String, String> PROPERTIES = ImmutableMap.<String, String>builder()
            .put(PropertyKeys.API_HOST, "https://api.github.com")
            .build();

    @Override
    public String getAsString(String key) {
        ArgAssert.isNotBlank(key);
        String value = PROPERTIES.get(key);
        ArgAssert.isNotBlank(value);
        return value;
    }
}
