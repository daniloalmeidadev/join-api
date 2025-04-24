Spring Boot Project Template

Firstly, you need to install the MySQL database. If you have Docker installed on your computer, you can run the following command to install and configure MySQL from Docker Hub:

`docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin132 -e MYSQL_DATABASE=api-db -p 3306:3306 -v mysql-data:/var/lib/mysql -d mysql:8.0`

Once Docker is installed and running, use the command below to start the API:

`./mvnw spring-boot:run`

Note: You need to enable Build Automatically in your IDE.
In IntelliJ, go to Settings > Build, Execution, Deployment > Compiler and check the option Build project automatically.
