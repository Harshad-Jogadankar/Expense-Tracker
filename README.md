# Microservices Project Setup Guide

This guide explains how to set up and run the project locally using IntelliJ IDEA, Maven, XAMPP, and Postman.

## Steps to Set Up the Project

1. **Clone the Repository**  
   Clone the repository and save it in a new folder on your local machine.

2. **Open Project in IntelliJ**  
   - Open IntelliJ IDEA.  
   - Select **File > Open**, and choose the folder where the repository is saved.  
   - IntelliJ will load the project as a Maven project.

3. **Load Maven Scripts**  
   - Locate the Maven menu on the right side of IntelliJ.  
   - Use the Maven menu to load all the required Maven scripts.

4. **Set Up the Database**  
   - Start XAMPP and ensure the MySQL service is running.  
   - Open [phpMyAdmin](http://localhost/phpmyadmin) in your browser.  
   - Create the required database for the project (refer to the SQL schema provided in the project repository).  
   - Import the database schema or create the tables manually if required.

5. **Open Service Applications**  
   Open the following service applications in IntelliJ:
   - `EurekaServerApplication`
   - `GatewayServiceApplication`
   - `UserServiceApplication`
   - `ExpenseServiceApplication`
   - `ReportServiceApplication`

6. **Ensure Ports Are Free**  
   Before starting the applications, ensure that the following ports are free:  
   - `8761`  
   - `8081`  
   - `8082`  
   - `8083`  
   - `8084`

7. **Run Applications**  
   Run the applications in the following order:  
   - **Step 1:** `EurekaServerApplication`  
   - **Step 2:** `GatewayServiceApplication`  
   - **Step 3:** `UserServiceApplication`  
   - **Step 4:** `ExpenseServiceApplication`  
   - **Step 5:** `ReportServiceApplication`

8. **Verify Eureka Server**  
   - Open your browser and go to `http://localhost:8761`.  
   - Ensure that the Eureka server is up and running.  
   - Verify that the remaining four services are registered as instances in the Eureka server.

9. **Test the Application**  
   - Open the **local Postman app** on your system.  
   - Use Postman to test the application functionality as demonstrated in the demo video.  
   - Import or create the necessary Postman collections for sending requests to the microservices.

## Additional Notes
- Ensure all required dependencies are downloaded and configured correctly in your environment.
- Refer to the demo video for specific Postman requests and responses.

---
