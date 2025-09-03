# MkLogistics Backend

A Spring Boot-based backend for the MkLogistics management system.

## 🚀 Quick Start

```bash
# Run using Maven wrapper
./mvnw spring-boot:run   # Linux/Mac
.\mvnw.cmd spring-boot:run  # Windows

# Or using Maven if installed
mvn spring-boot:run
```

## 🛠️ Tech Stack

- **Spring Boot 3.5.4** - Modern Java framework
- **Spring Data JPA** - Database access and ORM
- **PostgreSQL 17.5** - Robust database
- **Spring DevTools** - Development productivity tools
- **Maven** - Dependency management and build tool

## 📋 Features

### 🚛 Core Functionalities

1. **Cargo Management**
   - Create and track cargo
   - Manage cargo details and status

2. **Carrier Management**
   - Register and manage carriers
   - Track carrier performance

3. **Driver Management**
   - Driver registration and assignment
   - Track driver availability

4. **Truck Fleet Management**
   - Manage truck inventory
   - Track truck status and assignments

5. **Order Processing**
   - Create and manage orders
   - Track order status
   - Loading/Unloading management

6. **Address Management**
   - Manage pickup and delivery locations
   - Address validation

### 🔧 Technical Features

- **RESTful APIs** - Clean and well-documented endpoints
- **CORS Support** - Configured for frontend integration
- **Database Integration** - PostgreSQL with HikariCP connection pooling
- **Error Handling** - Global exception handling
- **Entity Relationships** - Complex domain model relationships
- **Auto-reload** - DevTools enabled for quick development

## 📁 Project Structure

```
MkLogistics/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/alpha/MkLogistics/
│   │   │       ├── controller/    # REST controllers
│   │   │       ├── service/       # Business logic
│   │   │       ├── repository/    # Data access
│   │   │       ├── entity/        # Domain models
│   │   │       ├── dto/           # Data transfer objects
│   │   │       └── exception/     # Exception handling
│   │   └── resources/
│   │       └── application.properties  # Configuration
│   └── test/                          # Unit tests
└── pom.xml                           # Dependencies
```

## 🔌 API Endpoints

### Customer APIs
```http
POST /cargo      # Create new cargo
POST /order      # Create new order
```

### Admin APIs
```http
POST   /carrier            # Create carrier
POST   /truck             # Add truck
POST   /driver            # Add driver
GET    /driver            # Get driver details
PUT    /driver            # Update driver
POST   /address          # Add address
PUT    /order            # Update order
```

## 🔧 Configuration

### Database Configuration
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mklogistics
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### CORS Configuration
```java
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
```

## 🏃‍♂️ Running the Application

### Prerequisites
- Java 17 or higher
- PostgreSQL 17.5
- Maven (optional)

### Steps
1. Configure database in `application.properties`
2. Run using Maven wrapper:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```
3. Access APIs at `http://localhost:8080`

## 🧪 Testing APIs

All APIs return standardized responses:
```json
{
  "code": 200,
  "message": "Operation Successful",
  "data": { }
}
```

## 📊 Database Schema

### Core Entities
- **Cargo**: Shipment details
- **Carrier**: Transport company info
- **Driver**: Driver information
- **Truck**: Vehicle information
- **Order**: Shipping order details
- **Address**: Location information

### Relationships
- Carrier ←→ Trucks (One-to-Many)
- Carrier ←→ Drivers (One-to-Many)
- Driver ←→ Truck (One-to-One)
- Order ←→ Cargo (Many-to-One)
- Order ←→ Loading/Unloading (One-to-One)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## 📝 License

This project is licensed under the MIT License.
