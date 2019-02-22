FROM java:8
EXPOSE 8080
ADD /target/spring-boot-bookstore.jar spring-boot-bookstore.jar
ENTRYPOINT [“java”, “-jar”, “spring-boot-bookstore.jar”]