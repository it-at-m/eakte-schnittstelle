# For documentation see https://jboss-container-images.github.io/openjdk/
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime:1.24-3.1791779558@sha256:856ee6542b8fdf09a065fd5439309fc3f3c821fb8efac48aa6191c93635dd907

# Copy runnable jar to deployments
COPY target/*.jar /deployments/application.jar

USER 0
RUN mkdir -p /deployments/eakte-external-config
USER $CONTAINER_USER_ID

# Definiere den Befehl zum Starten der Anwendung (passe dies an deine Anwendung an)
# CMD ["java", "-jar", "/deployments/application.jar", "--spring.config.additional-location=/deployments/eakte-external-config/application.yml" ]
CMD java $JAVA_TOOL_OPTIONS -jar "/deployments/application.jar" --spring.config.additional-location="/deployments/eakte-external-config/application.yml"
