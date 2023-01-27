FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_losevod_java_bot
ENV BOT_TOKEN=5787374810:AAHW_VNUTHUaMLaLOZSHLS5y4cGoE725I28
ENV BOT_DB_USERNAME=jtb_db_user
ENV BOT_DB_PASSWORD=jtb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "/app.jar"]