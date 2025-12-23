package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.annotation.ValueObject;

import java.util.Map;

/**
 * Value object representing user metadata (like last conversation with AI).
 *
 * @param values A map containing metadata key-value pairs.
 */

@ValueObject
public record UserMetadata(Map<String, Object> values) {
    public String getLastIntent() {
        return (String) values.getOrDefault("last_ai_intent", "NONE");
    }

    public void put(String key, Object value) {
        values.put(key, value);
    }
}
