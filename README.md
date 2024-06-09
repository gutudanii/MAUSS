---
# Mattu University Special School Web Application
![Project Logo](Mattu-University-Special-School/src/main/resources/static/images/home.jpg)

## Overview
This project is a web-based application designed for Mattu University Special School, developed as a final year project for a B.Sc. in Computer Science. The application provides a comprehensive platform for managing student information, facilitating communication, and enhancing the educational experience through various features such as user authentication, mark list management, material access, test practice, and more.

## Technologies Used
- **Backend Framework:** Spring Boot
- **Database:** MySQL
- **Frontend:** Thymeleaf, HTML, CSS, JavaScript
- **Security:** Spring Security
- **Email:** Spring Boot Starter Mail
- **Development Tools:** Maven, Lombok

## Functional Requirements
The system includes several key functionalities to meet the needs of its users:

1. **User Authentication:** Secure login with role-based access control for students, teachers, and administrators.
2. **Mark List Management:** Teachers can input, manage, and update student marks through an intuitive interface.
3. **Material Access:** Users can access and download course materials organized by subject and class.
4. **Test Practice:** Provides students with practice test cases, instant feedback, and progress tracking.
5. **Announcements and Updates:** Teachers can post announcements and updates, with options for students to comment and react.
6. **User Profile Management:** Users can manage their profiles and update personal information.
7. **Data Synchronization:** Ensures consistent data synchronization across web and mobile platforms.
8. **Registration System:** Facilitates user registration for new students, teachers, and administrators with options for verification and approval.

## Project Setup

### Prerequisites
- Java 17
- Maven
- MySQL
- Spring Boot

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/gutudanii/MAUSS.git
   cd MAUSS
   ```

2. **Setup MySQL Database:**
   ```sql
   CREATE DATABASE mauss;
   ```

3. **Configure Database in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mauss
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Run the Application:**
   ```sh
   mvn spring-boot:run
   ```

### Configuration

- **Email Configuration:** Update the email settings in `application.properties` to configure the email service.
  ```properties
  spring.mail.host=smtp.gmail.com
  spring.mail.port=587
  spring.mail.username=your-email@gmail.com
  spring.mail.password=your-email-password
  spring.mail.properties.mail.smtp.auth=true
  spring.mail.properties.mail.smtp.starttls.enable=true
  ```

## Project Structure

- **src/main/java:** Contains the Java source files.
- **src/main/resources:** Contains the configuration files and templates.
- **pom.xml:** Project Object Model file for Maven dependencies.

## Dependencies

Here are the key dependencies listed in the `pom.xml` file:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Application Properties

Here are the essential properties listed in the `application.properties` file:
```properties
spring.application.name=Mattu-University-Special-School
spring.datasource.url=jdbc:mysql://localhost:3306/mauss
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.thymeleaf.enabled=true
server.port=8090
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=***@gmail.com
spring.mail.password=**********
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

## Running Tests

Run the following command to execute the tests:
```sh
mvn test
```
Here is the link to demo of the Front End only <a href="https://mauss.netlify.app/" target="blank_">MAUSS WEB</a>
## Contribution

Contributions are welcome! Please fork this repository and submit pull requests for any enhancements or bug fixes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or questions, feel free to contact us at:
- **Email:** gutudanielgeleta@gmail.com
- **Phone:** +251 994 120 201
- **Address:** 8H95+479, Metu, Oromia, Ethiopia

---
