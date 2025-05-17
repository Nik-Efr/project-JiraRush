FROM eclipse-temurin:17-jre-alpine

WORKDIR /opt/app

RUN addgroup --system javauser && adduser -S -s /sbin/nologin -G javauser javauser

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

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

RUN chown -R javauser:javauser .

USER javauser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
