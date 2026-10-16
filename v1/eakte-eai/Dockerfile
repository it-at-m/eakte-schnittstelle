# For documentation see https://jboss-container-images.github.io/openjdk/
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24-3.1790283193@sha256:45af2087488812260f0cb6c744fadfe0b4e16c6f46232a05a57d7d0ddf1aa55d

# Copy runnable jar to deployments
COPY target/*.jar /deployments/application.jar

USER 0
RUN mkdir -p /deployments/eakte-external-config
USER $CONTAINER_USER_ID

# Definiere den Befehl zum Starten der Anwendung (passe dies an deine Anwendung an)
# CMD ["java", "-jar", "/deployments/application.jar", "--spring.config.additional-location=/deployments/eakte-external-config/application.yml" ]
CMD java $JAVA_TOOL_OPTIONS -jar "/deployments/application.jar" --spring.config.additional-location="/deployments/eakte-external-config/application.yml"
