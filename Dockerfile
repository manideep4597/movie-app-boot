FROM openjdk:10
#temp
ADD ./target/movie-cruiser-app-0.0.1-SNAPSHOT.jar /usr/src/movie-cruiser-app-0.0.1-SNAPSHOT.jar
EXPOSE 8090
WORKDIR usr/src
ENTRYPOINT ["java","-jar","movie-cruiser-app-0.0.1-SNAPSHOT.jar"]
