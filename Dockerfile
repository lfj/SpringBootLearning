# 使用 OpenJDK 8 作为基础镜像
FROM --platform=$BUILDPLATFORM openjdk:8-jdk-alpine

# 创建工作目录
WORKDIR /app

# 复制构建好的 JAR 包到容器中
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# 暴露端口（根据你的应用实际端口配置）
EXPOSE 8501

# 启动 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]
