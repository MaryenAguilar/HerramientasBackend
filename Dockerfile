# Usar imagen de Maven para compilar
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Crear directorio de trabajo
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Construir JAR sin tests
RUN mvn clean package -DskipTests

# Segunda etapa: imagen optimizada
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
