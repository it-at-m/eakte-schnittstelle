package de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft;

import de.muenchen.oss.eakte.api.v2.gateway.adapter.out.fabasoft.domain.FabasoftObjectType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FabasoftAkteOutAdapter {
    private static final String PARENT_QUERY = ".COOELAK@1.1001:referrednumber = '%s'";

    public static String getParentQuery(final String id) {
        if (!StringUtils.hasText(id) || !id.matches(FabasoftObjectType.COO_PATTERN)) {
            throw new IllegalArgumentException("Invalid id: " + id);
        }
        return PARENT_QUERY.formatted(id);
    }
}
