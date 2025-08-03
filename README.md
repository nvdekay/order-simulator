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
- In-memory storage using HashMap

---

## 🚀 How to Run This Project (Step-by-Step from Scratch)

1. Make sure you have installed:
    - Java JDK 21
    - Maven 3.9+
    - IntelliJ IDEA (Community or Ultimate)

2. Clone the repository:
   ```
   git clone https://github.com/nvdekay/order-simulator.git
   cd order-simulator
   ```

3. Build the project:
    - Open pom.xml -> Right click and choose "Maven" -> Click "Sync Project"
    - Check in Project Structure and make sure you are using SDK 21

4. Run the project
    - From IntelliJ: Right-click OrderSimulatorApplication.java → Click “Run”

5. Access the Swagger UI for API testing:
   - Open your browser and go to:
   ```
   http://localhost:8080/ui
   ```
6. In Swagger UI, you can test the following endpoints:
   - POST /api/orders → Create a new order
   - GET /api/orders → Get all orders
   - GET /api/orders/{id} → Get order by ID
   - POST /api/orders/{id}/cancel → Cancel order (only if status is PENDING)
   - POST /api/orders/simulate-order → Randomly execute PENDING orders

### Example request for creating an order:
```
{
  "symbol": "FPT",
  "price": 100.50,
  "quantity": 10,
  "side": "BUY"
}
```

