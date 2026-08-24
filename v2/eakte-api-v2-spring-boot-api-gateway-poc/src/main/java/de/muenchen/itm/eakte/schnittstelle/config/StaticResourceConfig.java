package de.muenchen.itm.eakte.schnittstelle.config;

import org.jspecify.annotations.NullMarked;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Configuration
@NullMarked
public class StaticResourceConfig implements WebMvcConfigurer {

  public static Optional<String> findGitRoot() {
    Path dir = Paths.get("").toAbsolutePath();
    while (dir != null) {
      Path git = dir.resolve(".git");
      if (Files.exists(git)) {
        return Optional.of(dir.toString());
      }
      dir = dir.getParent();
    }
    return Optional.empty(); // not inside a git repo
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    Optional<String> gitRoot = findGitRoot();
    String[] resourceLocations;
    if (gitRoot.isPresent()) {
      // for quick development let the started web server serve directly from file system without
      // requiring a rebuild:
      String contentRoot = gitRoot.get() + File.separator +
        "m400-rest-api-v2-spring-boot-api-gateway/src/main/resources/static";
      resourceLocations = List.of("file:" + contentRoot, "classpath:/static/").toArray(String[]::new);
    } else {
      resourceLocations = List.of("classpath:/static/").toArray(String[]::new);
    }
    registry.addResourceHandler("/**")
      .addResourceLocations(resourceLocations);
  }
}