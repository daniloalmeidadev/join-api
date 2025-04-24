# Spring Boot Project Template

It's a template Spring Boot API.

## Technology

Spring Boot
Java
Hibernate
MySQL
Lombok
Devtools
Swagger

## Getting Started

Firstly, you need to install the MySQL database. If you have Docker installed on your computer, you can run the following command to install and configure MySQL from Docker Hub:

`docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin132 -e MYSQL_DATABASE=api-db -p 3306:3306 -v mysql-data:/var/lib/mysql -d mysql:8.0`

Once Docker is installed and running, use the following command to start the API:

`./mvnw spring-boot:run`

Note: You need to enable Build Automatically in your IDE.
In IntelliJ, go to Settings > Build, Execution, Deployment > Compiler and check the option Build project automatically.

## How to use

Below is an example of a POST request to create a Category:

![image](https://github.com/user-attachments/assets/690870b3-7711-4f24-b88c-5fc90bfe62c9)

You can see all the endpoints through Swagger at the link `http://localhost:8080/swagger-ui/index.html`:

![image](https://github.com/user-attachments/assets/54d10384-5594-457c-ae9c-4d93a28633f2)

## Links

https://github.com/daniloalmeidadev/template-api

## Versioning

1.0.0.0

## Authors

Danilo Almeida (https://github.com/daniloalmeidadev)
