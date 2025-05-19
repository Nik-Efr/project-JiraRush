FROM eclipse-temurin:17-jre-alpine

FROM maven:3.8.4-amazoncorretto-17 as build
WORKDIR app/
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
ENV DB_PASSWORD=JiraRush \
    DB_USERNAME=jira \
    GITHUB_CLIENT_ID=3d0d8738e65881fff266 \
    GITHUB_CLIENT_SECRET=0f97031ce6178b7dfb67a6af587f37e222a16120 \
    GITLAB_CLIENT_ID=b8520a3266089063c0d8261cce36971defa513f5ffd9f9b7a3d16728fc83a494 \
    GITLAB_CLIENT_SECRET=e72c65320cf9d6495984a37b0f9cc03ec46be0bb6f071feaebbfe75168117004 \
    GOOGLE_CLIENT_ID=329113642700-f8if6pu68j2repq3ef6umd5jgiliup60.apps.googleusercontent.com \
    GOOGLE_CLIENT_SECRET=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 \
    MAIL_HOST=smtp.gmail.com \
    MAIL_PASSWORD=zdfzsrqvgimldzyj \
    MAIL_PORT=587 \
    MAIL_USERNAME=jira4jr@gmail.com
WORKDIR /app
COPY --from=build /app/target/jira-1.0.jar /app/
COPY ./resources /app/resources

EXPOSE 8080
CMD ["java", "-jar", "jira-1.0.jar"]
