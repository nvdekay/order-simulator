# 🧠 Order Simulator - Spring Boot Application

This is a backend simulator for High-Frequency Trading (HFT) orders using Spring Boot.  
It simulates order creation, retrieval, cancellation, and execution without using a database — data is stored in-memory.

---

## ⚙️ Technologies Used

- Java 21
- Spring Boot 3
- Maven
- Spring Web
- Spring Validation
- Lombok
- SpringDoc OpenAPI (Swagger UI)
- In-memory storage using ConcurrentHashMap

---

## 🚀 How to Run This Project (Step-by-Step from Scratch)

1. Make sure you have installed:
    - Java JDK 21 or higher
    - Maven 3.9+
    - IntelliJ IDEA (Community or Ultimate)

2. Clone the repository:
   ```bash
   git clone https://github.com/nvdekay/order-simulator.git
   cd order-simulator

3. Build the project:
    - Open terminal in IntelliJ or system terminal
    - Run:
    ```bash
   ./mvnw clean install
   
4. Run the project
    - Option 1: (from IntelliJ): Right-click OrderSimulatorApplication.java → Click “Run”
    - Option 2: (from terminal):
   ```bash
   ./mvnw spring-boot:run

5. Access the Swagger UI for API testing:
   - Open your browser and go to:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```
6. In Swagger UI, you can test the following endpoints:
   - POST /api/orders → Create a new order
   - GET /api/orders → Get all orders
   - GET /api/orders/{id} → Get order by ID
   - POST /api/orders/{id}/cancel → Cancel order (only if status is PENDING)
   - POST /api/orders/simulate-execution → Randomly execute PENDING orders

### Example request for creating an order:
```
{
  "symbol": "FPT",
  "price": 100.50,
  "quantity": 10,
  "side": "BUY"
}
```

