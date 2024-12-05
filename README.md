
# Project Title  
Insurance Report Generation  

## Description  
This project is a simple mini Insurance Report Generation application designed to provide users
with their insurance reports. Users can generate detailed insurance reports and send them directly
to their email in either Excel or PDF format. This project aims to streamline the process of accessing
and sharing insurance-related information in a user-friendly and efficient manner.
## Features  
- Generating insurance reports based on user inputs.
- Exporting reports in Excel or PDF formats.
- Sending the generated reports directly to the user's email.

## Technologies Used  
- **Backend**: Java, Spring Boot, Spring Boot Starter Mail
- **Frontend**: HTML, JSP, JSTL, Bootstrap
- **Database**: MySQL
- **Libraries/Tools**:
		- poi-ooxml: For generating Excel reports
		- OpenPDF: For generating PDF reports  

## Installation  
### Prerequisites  
Ensure you have the following installed on your system:  
- **Java 1.8 or higher**  
- **Apache Maven**  
- **MySQL Server**  
- **An IDE (e.g., Eclipse, IntelliJ IDEA)**  

### Steps  

1. **Clone the Repository**  
   Clone the project repository to your local machine:  
   ```bash
   git clone [Repository Link](https://github.com/your-username/insurance-report-generator.git)
   cd insurance-report-generator 
   
2.  **Set Up the Database**

- Open your MySQL client and create a new database:
- CREATE DATABASE insurance_report_db;
- Configure Application Properties
- Navigate to src/main/resources/application.properties.
- Update the database connection details as per your local setup:
- properties
    - spring.datasource.url=jdbc:mysql://localhost:3306/insurance_report_db
    - spring.datasource.username=your-username
    - spring.datasource.password=your-password
    - spring.jpa.hibernate.ddl-auto=update
- Configure email settings for sending reports:
- properties
    - spring.mail.host=smtp.example.com
    - spring.mail.port=587
    - spring.mail.username=your-email@example.com
    - spring.mail.password=your-email-password
    - spring.mail.properties.mail.smtp.auth=true
    - spring.mail.properties.mail.smtp.starttls.enable=true
3. **Build and Run the Application**
    - Use Maven to build and run the application:
    - mvn spring-boot:run
4. **Access the Application**

	- Open your browser and navigate to:
    - http://localhost:8080
5. **Generate and Send Reports**
    - Follow the UI instructions to generate an insurance report and send it via email in Excel or PDF format.

# Database Schema
# Project Structure

 	