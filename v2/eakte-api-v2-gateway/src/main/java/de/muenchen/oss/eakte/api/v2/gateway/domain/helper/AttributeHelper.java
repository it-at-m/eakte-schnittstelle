package de.muenchen.oss.eakte.api.v2.gateway.domain.helper;

import java.util.HashSet;
import java.util.Set;

public final class AttributeHelper {
    private AttributeHelper() {
    }

    public static Set<String> combineAttributes(final Set<String> set1, final Set<String> set2) {
        if (set1 == null && set2 != null) {
            return set2;
        }
        if (set1 != null && set2 == null) {
            return set1;
        }
        if (set1 == null) {
            throw new IllegalArgumentException("Both sets are null");
        }
        final Set<String> combined = new HashSet<>(set1);
        combined.addAll(set2);
        return combined;
    }
}
