FROM java:8-jre

ADD ./target/mediarate-api.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/mediarate-api.jar"]

EXPOSE 8080