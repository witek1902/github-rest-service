package witkowski.robert.github.rest.service.integration.common;

/**
 * This interface is responsible for provide static property from resource (file, database, etc.)
 */
public interface PropertyProvider {
    /**
     * Get property for selected key. If property not exists - method should throws one of RuntimeException.
     *
     * @param key - Key of property
     * @return - String with property value.
     */
    String getAsString(String key);
}
