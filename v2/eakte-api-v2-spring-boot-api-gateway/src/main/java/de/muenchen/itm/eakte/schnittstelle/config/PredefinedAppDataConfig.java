package de.muenchen.itm.eakte.schnittstelle.config;

import de.muenchen.itm.eakte.schnittstelle.rest_v2.server_stubs.model.Attributbeschreibung;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "app-configuration")
@Getter
@Setter
public class PredefinedAppDataConfig {

  private int attributeCacheMaxTimeToLiveInSeconds;
  private String funktionsUsername;
  private String funktionsPassword;
  private List<Attributbeschreibung> attributbeschreibungen;

}
