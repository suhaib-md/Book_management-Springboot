# Book Management Mini Kindle-like App

This project is a mini Kindle-like application built using Java Spring Boot, secured with JWT authentication, and designed to manage books through a REST API. It provides basic functionalities such as user authentication, book listing, and management.

## Features

- **User Authentication:** JWT-based authentication for secure access.
- **Book Management:** CRUD operations for managing books via REST API.
- **Security:** Secured endpoints and static resource access using Spring Security.

## Usage

### Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven
- IDE (e.g., IntelliJ IDEA, Eclipse, Visual Studio Code)

### Installation Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/suhaib-md/Book_management-Springboot.git
   ```

2. **Configure application.yml:**

   Update the `application.yml` file with your RSA public and private keys under `rsa`.

3. **Build the application:**

   ```bash
   mvn clean package
   ```

4. **Run the application:**

   ```bash
   java -jar target/Book_management-Springboot.jar
   ```

5. **Access the application:**

   Open your web browser and go to [http://localhost:8080](http://localhost:8080) to access the application.

### API Documentation

- **Authentication:**
  - `/token`: POST request to obtain a JWT token.
 
  ![image](https://github.com/user-attachments/assets/30c9d4e2-eea7-43a7-b9cc-188eb293d506)

  - Using the Bearer token to perform authorization and gain access.

  ![image](https://github.com/user-attachments/assets/afe53727-a465-489b-8a0a-67b87c331069)

- **Book Management:**
  - `/api/books`: CRUD operations for managing books.

    - CREATE
      
      ![image](https://github.com/user-attachments/assets/4c3d2a2f-aa16-4cb6-a85e-912ca0a4a814)
      
    - READ ALL
    
      ![image](https://github.com/user-attachments/assets/15d2462f-8ab1-47f8-b878-49ee69bfea4e)

    - READ ONE
      
      ![image](https://github.com/user-attachments/assets/33c14488-f146-43c4-929a-9a2ab35f831b)

    - UPDATE
      
      ![image](https://github.com/user-attachments/assets/b1edd18a-86fb-4bd1-bd7e-5c42255af0aa)
      ![image](https://github.com/user-attachments/assets/085eacc7-d007-43fb-a074-0bc63dca089f)

    - DELETE
    
      ![image](https://github.com/user-attachments/assets/455a9667-48bf-4046-8a7e-caf987fbdc2d)
      ![image](https://github.com/user-attachments/assets/130c7cc5-a561-40a3-9de5-a7d722bbb24a)

### Example Usage

1. **Obtain JWT Token:**

   Use tools like Postman to send a POST request to `/token` with credentials to obtain a JWT token.

2. **Manage Books:**

   Use tools like Postman or a web browser to access `/api/books` endpoints for managing books.

### Contributing

Feel free to contribute to this project by submitting pull requests or reporting issues. Your feedback and contributions are welcome!
