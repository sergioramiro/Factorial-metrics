# Factorial-metrics

1. [Description](#description)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Use](#use)
5. [Interesting points to discuss](#Interesting-points-to-discuss)

## Description ℹ️

This project consists of a Frontend + Backend application that allows publishing and visualizing metrics. Each metric will be composed of a timestamp, name, and value. The metrics will be displayed on a timeline and should include averages per minute/hour/day. Additionally, the metrics will be persisted in the database.## Tabla de Contenidos

## Technologies 💻

- **Frontend:** Developed with React in TypeScript and SWC, the frontend utilizes the following main technologies and tools:

    - `React`: JavaScript library for building user interfaces.
    - `SWC`: JavaScript/TypeScript compiler focused on speed and parallelism.
    - `TanStack Query`: Library for managing server state in React applications.
    - `Recharts`: Library for building charts using React components.
    - `Vite`: Build tool that aims to provide a fast development experience.
    - `Tailwind CSS`: Utility-first CSS framework for quickly building custom designs.
- 
- **Backend:** Developed in Java 17 and Spring Boot, the backend uses the following main technologies:

  - `Spring Boot`: Framework for Java application development.
  - `JPA (Java Persistence API)`: For accessing and managing data in the relational database.
  - `PostgreSQL`: Relational database management system used as the storage engine.
  - `Flyway`: Database migration tool, used for controlled management and updates of the database schema.
  - `JUnit`: Framework for unit testing in Java, ensuring the quality of the codebase.
  - `Testcontainers`: Used for integration testing by running Docker containers, ensuring an isolated and reproducible environment for testing.

Dependencies are managed by Gradle, ensuring efficient and easy-to-maintain backend development.

## Installation 🛠️

Step-by-step instructions to install and configure the project locally.
### Prerequisites 📦

Before you start, make sure you have the following installed:

- Docker 🐳: Necessary to lift and run the full application, including frontend and backend services in an integrated way.
- Internet connection 🌐: To download dependencies and additional resources as needed.

These requirements are essential to configure and run the project effectively.

### Start the application. 🖥️

To install and run the application, follow these steps:
1. Clone the repository:    
    ```bash
    git clone https://github.com/sergioramiro/Factorial-metrics.git
    cd Factorial-metrics
    ```

2. Start the application using Docker.
    ```bash
    docker-compose up -d
    ```

This will place the application in the root folder `Factorial-metrics` and run all necessary services in Docker.
## Use 🚀

Once the application is up and running, open your web browser and go to:
```
http://localhost:3000/
```

At this web address you will find the app launched and you can start exploring and testing all its features.

# Interesting points to discuss

- comentar que el boton minuto no cambia por los datos
