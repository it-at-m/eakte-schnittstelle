package de.muenchen.oss.eakte.api.v2.gateway;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings({ "PMD.TestClassWithoutTestCases" })
public final class TestConstants {
    public static final String SPRING_TEST_PROFILE = "test";
    public static final String BENUTZER_ID = "COO.USER.1";
    public static final String BENUTZER_USERNAME = "username";
    public static final String BENUTZER_MANDANT = "client-domain";
    public static final String BENUTZER_OE_ID = "COO.GROUP.1";
    public static final String BENUTZER_OE_NAME = "group-name";
}
