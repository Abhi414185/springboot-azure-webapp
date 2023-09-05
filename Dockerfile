FROM openjdk:8
EXPOSE 8080
ADD target/productcatalogbackend.jar productcatalogbackend.jar
ENTRYPOINT ["java","-jar","/productcatalogbackend.jar"]
