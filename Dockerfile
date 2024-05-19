# C'est un fichier Dockerfile qui spécifie comment créer une image Docker pour une application Java.
FROM docker-registry-devops.pf.echnonet/bnpp-pf/openjdk9-jre-17-4
ARG ARTIFACT_FILE
ADD ${ARTIFACT_FILE} /applis/application.jar
EXPOSE 8080
USER 1001
CMD ["/bin/sh", "-c", "java ${JAVA_OPTS} -jar -Dspring.profiles.active=cloud /applis/application.jar"]
