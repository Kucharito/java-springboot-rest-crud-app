# Java II Spring Project – REST API + Frontend

This project demonstrates a simple **Spring Boot REST API** with an **H2 in-memory database** and a lightweight **HTML/JavaScript frontend**.  
It was created as part of the Java II course and shows how to build and use a CRUD application with backend–frontend interaction.  

---

## ⚙️ Tech stack
- **Java 21**
- **Spring Boot 3.2** (Spring Web, Spring Data JPA, Hibernate)
- **H2 in-memory database** (with H2 console)
- **Maven** – build & dependency management
- **Lombok**
- **HTML + JavaScript** – simple frontend consuming the API

---
## 🚀 Running the project

### 2. Run with Maven
```bash
mvn spring-boot:run
```
or open in IntelliJ IDEA and run **ProjektRestAppApplication.java.**


### 3. Access the app
- REST API: [http://localhost:8081](http://localhost:8081)  
- H2 console: [http://localhost:8081/h2](http://localhost:8081/h2)  
  - JDBC URL: `jdbc:h2:mem:testdb`  
  - User: `sa`  
  - Password: *(leave empty)*

---

## 🗄️ Database schema (auto-generated)

### Teams (TIMY)
- `id`
- `nazovTimu`
- `skratkaTimu`
- `krajinaPovodu`

### Players (HRACI)
- `id`
- `meno`
- `priezvisko`
- `datumNarodenia`
- `pozicia`
- `tim_id`

### Coaches (TRENERI)
- `id`
- `meno`
- `priezvisko`
- `specializacia`
- `tim_id`





## 🌍 REST API Endpoints

### Teams
| Method | Endpoint                | Description             |
|--------|--------------------------|-------------------------|
| GET    | `/getAllTeams`           | Get all teams           |
| GET    | `/getTeamById/{id}`      | Get team by ID          |
| POST   | `/addTeam`               | Create new team         |
| PUT    | `/updateTeamById/{id}`   | Update existing team    |
| DELETE | `/deleteTeamById/{id}`   | Delete team by ID       |

### Players
| Method | Endpoint                   | Description              |
|--------|-----------------------------|--------------------------|
| GET    | `/getAllPlayers`            | Get all players          |
| GET    | `/getPlayerById/{id}`       | Get player by ID         |
| POST   | `/addPlayer`                | Create new player        |
| PUT    | `/updatePlayerById/{id}`    | Update existing player   |
| DELETE | `/deletePlayerById/{id}`    | Delete player by ID      |

### Coaches
| Method | Endpoint                   | Description              |
|--------|-----------------------------|--------------------------|
| GET    | `/getAllCoaches`            | Get all coaches          |
| GET    | `/getCoachById/{id}`        | Get coach by ID          |
| POST   | `/addCoach`                 | Create new coach         |
| PUT    | `/updateCoachById/{id}`     | Update existing coach    |
| DELETE | `/deleteCoachById/{id}`     | Delete coach by ID       |


## 📑 Example requests (Postman / curl)

### 🟢 Create a team
```http
POST http://localhost:8081/addTeam
Content-Type: application/json

{
  "nazovTimu": "Spartans",
  "skratkaTimu": "SPR",
  "krajinaPovodu": "SK"
}
```

### Create a player (with team id 1)
```http
POST http://localhost:8081/addPlayer
Content-Type: application/json
{
  "meno": "Jozef",
  "priezvisko": "Mrkva",
  "pozicia": "Forward",
  "datumNarodenia": "2000-05-01",
  "tim": { "id": 1 }
}
```

### GetAllTeams 
```http
GET http://localhost:8081/getAllTeams
```


## 🖥️ Frontend (NovyProjektJava.html)

The project also includes a simple **HTML/JavaScript frontend** that consumes the REST API.

### How to use
1. Start the backend (**ProjektRestApp**) on [http://localhost:8081](http://localhost:8081).  
2. Open `NovyProjektJava.html` in your browser.  
3. The page allows you to:
   - view teams, players, and coaches,
   - add new records,
   - update existing ones,
   - delete records.

This way, you can interact with the application through a **web interface** without needing Postman.

---

## 🧑‍💻 Author
Created by **Adam Kuchár**  
