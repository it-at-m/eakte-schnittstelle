# For documentation see https://jboss-container-images.github.io/openjdk/
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24-3.1794341129@sha256:9a074c2ff90be60b12521ffd5e531acafd25fe36f1c177180cbe1176dfb36c84

# Copy runnable jar to deployments
COPY target/*.jar /deployments/application.jar

USER 0
RUN mkdir -p /deployments/eakte-external-config
USER $CONTAINER_USER_ID

# Definiere den Befehl zum Starten der Anwendung (passe dies an deine Anwendung an)
# CMD ["java", "-jar", "/deployments/application.jar", "--spring.config.additional-location=/deployments/eakte-external-config/application.yml" ]
CMD java $JAVA_TOOL_OPTIONS -jar "/deployments/application.jar" --spring.config.additional-location="/deployments/eakte-external-config/application.yml"
