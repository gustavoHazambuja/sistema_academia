# 1. Imagem base com Java 21
FROM eclipse-temurin:21-jdk-alpine

# 2. Diretório de trabalho dentro do container
WORKDIR /app

# 3. Copia o JAR para dentro do container
COPY target/sistema_academia-0.0.1-SNAPSHOT.jar app.jar

# 4. Expõe a porta 8080
EXPOSE 8080

# 5. Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]