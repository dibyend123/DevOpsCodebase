FROM frolvlad/alpine-oraclejdk8:slim
COPY devopscal-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
