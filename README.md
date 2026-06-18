# Champions League Pronostiek

Webapplicatie waarmee gebruikers een Champions League-team samenstellen en punten verdienen op basis van de prestaties van hun geselecteerde spelers.

## Tech Stack

**Frontend:** React, TypeScript, TailwindCSS, React Router, TanStack Query, Axios

**Backend:** Java 21, Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, Hibernate

**Database:** PostgreSQL

**Externe API:** SoccerData API

**Hosting:** Vercel (frontend), Render (backend), Neon PostgreSQL (database)

---

## Vereisten

| Tool | Versie |
|---|---|
| Node.js | 22+ |
| npm | laatste |
| Java | 21 |
| Maven | laatste |
| PostgreSQL | 16+ |

Controleer installatie:

```bash
node -v
npm -v
java -version
mvn -version
psql --version
```

---

## Project Structuur

```text
champions-league-prono/
│
├── frontend/
├── backend/
├── database/
├── docs/
└── README.md
```

---

## Repository Clonen

```bash
git clone https://github.com/seppedewolf6/champions-league-prono.git
cd champions-league-prono
```

---

## Database Setup

Open PostgreSQL:

```bash
psql -U postgres
```

Maak database, gebruiker en geef rechten:

```sql
CREATE DATABASE champions_league_prono;
CREATE USER prono_user WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE champions_league_prono TO prono_user;
```

Verlaat PostgreSQL:

```sql
\q
```

---

## Backend Setup

```bash
cd backend
```

Maak `src/main/resources/application.properties` aan:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/champions_league_prono
spring.datasource.username=prono_user
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update

jwt.secret=your-secret-key
jwt.expiration=86400000

soccerdata.api.key=YOUR_API_KEY
```

Dependencies installeren:

```bash
mvn clean install
```

Backend starten:

```bash
# Windows
mvnw.cmd spring-boot:run
```

Backend draait op: `http://localhost:8080`

---

## Frontend Setup

Open een tweede terminal.

```bash
cd frontend
```

Dependencies installeren:

```bash
npm install
```

Maak `.env` aan:

```env
VITE_API_URL=http://localhost:8080/api
```

Frontend starten:

```bash
npm run dev
```

Frontend draait op: `http://localhost:5173`

---

## Dagelijkse Development Workflow

**Backend starten**

```bash
cd backend
./mvnw spring-boot:run
```

**Frontend starten**

```bash
cd frontend
npm run dev
```

**Git wijzigingen ophalen**

```bash
git pull origin main
```

**Nieuwe branch maken**

```bash
git checkout -b feature/login
```

**Wijzigingen committen**

```bash
git add .
git commit -m "Implement login functionality"
```

**Pushen**

```bash
git push origin feature/login
```

---

## Build

**Frontend**

```bash
npm run build
```

Output: `frontend/dist`

**Backend**

```bash
mvn clean package
```

Output: `target/prono.jar`

Backend starten vanuit jar:

```bash
java -jar target/prono.jar
```

---

## API Endpoints

### Authentication
```http
POST /api/auth/register
POST /api/auth/login
```

### Teams
```http
GET  /api/teams
POST /api/teams
PUT  /api/teams
```

### Players
```http
GET /api/players
```

### Matches
```http
GET /api/matches
```

### Rankings
```http
GET /api/rankings
```

### Admin
```http
GET  /api/admin/users
PUT  /api/admin/users/{id}/verify
POST /api/admin/recalculate
```

---

## Teamregels

Elk team bestaat uit:

- 1 Keeper
- 4 Verdedigers
- 3 Middenvelders
- 3 Aanvallers

Beperkingen:

- Enkel spelers uit Champions League-ploegen
- Maximum 2 spelers van dezelfde ploeg
- Geen budgetsysteem
- Geen transfers tijdens het seizoen
- Teams worden automatisch gelockt zodra de eerste Champions League-wedstrijd start

---

## Puntensysteem

| Actie | Punten |
|---|---|
| Goal — Keeper | +10 |
| Goal — Verdediger | +7 |
| Goal — Middenvelder | +5 |
| Goal — Aanvaller | +2 |
| Assist (alle posities) | +3 |
| Clean Sheet (Keeper) | +2 |
| Penalty Save (Keeper) | +2 |
| Gewonnen wedstrijd | +3 |
| Gelijkspel | +1 |
| Verloren wedstrijd | 0 |
| Gele kaart | -1 |
| Rode kaart | -3 |
| Gemiste penalty | -1 |
| Eigen doelpunt | -1 |

> Bij knock-outwedstrijden tellen penaltyreeksen niet mee als penalties.

---

## Deployment

**Frontend (Vercel)**

```bash
npm run build
```

Build directory: `frontend/dist`

**Backend (Render)**

Build Command:

```bash
./mvnw clean package
```

Start Command:

```bash
java -jar target/*.jar
```

**Database (Neon PostgreSQL)**

Configureer de Neon connection string als environment variable binnen Render.

---

## Toekomstige Features

- Transfers tijdens knock-outs
- Live score updates
- Push notificaties
- Gedetailleerde statistieken
- Meerdere competities
- Mobiele applicatie
- Automatische prijsberekening

---

## Team

Champions League Pronostiek Project — 2026