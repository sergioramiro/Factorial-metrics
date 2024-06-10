# Factorial-metrics

1. [**Description**](#description)
2. [**Technologies**](#technologies)
3. [**Installation**](#installation)
4. [**How to use**](#How-to-use)
5. [**Decisions and Trade-offs**](#decisions-and-trade-offs)
6. [**Challenges faced**](#Challenges-faced)
7. [**Things to add or improve**](#Things-to-add-or-improve)

## **Description** ℹ️

This project consists of a Frontend + Backend application that allows publishing and visualizing metrics. Each metric will be composed of a timestamp, name, and value. The metrics will be displayed on a timeline and should include averages per minute/hour/day. Additionally, the metrics will be persisted in the database.

## **Technologies** 💻

- **Frontend:** Developed with React in TypeScript and SWC, the frontend utilizes the following main technologies and tools:

    - **`React`**: JavaScript library for building user interfaces.
    - **`SWC`**: JavaScript/TypeScript compiler focused on speed and parallelism.
    - **`TanStack Query`**: Library for managing server state in React applications.
    - **`Recharts`**: Library for building charts using React components.
    - **`Vite`**: Build tool that aims to provide a fast development experience.
    - **`Tailwind CSS`**: Utility-first CSS framework for quickly building custom designs.

- **Backend:** Developed in Java 17 and Spring Boot, the backend uses the following main technologies:

  - **`Spring Boot`**: Framework for Java application development.
  - **`JPA`**: For accessing and managing data in the relational database.
  - **`PostgreSQL`**: Relational database management system used as the storage engine.
  - **`Flyway`**: Database migration tool, used for controlled management and updates of the database schema.
  - **`JUnit`**: Framework for unit testing in Java, ensuring the quality of the codebase.
  - **`Testcontainers`**: Used for integration testing by running Docker containers, ensuring an isolated and reproducible environment for testing.

Dependencies are managed by Gradle.

## **Installation** 🛠️

Step-by-step instructions to install and configure the project locally.

### **Prerequisites** 📦

Before you start, make sure you have the following installed:

- [Docker](https://docs.docker.com/engine/install/) 🐳
- Internet connection 🌐

These requirements are essential to configure and run the project effectively.

### **Start the application** 🖥️

>To install and run the application, follow these steps:
>1. Clone the repository:    
>    ```bash
>    git clone https://github.com/sergioramiro/Factorial-metrics.git
>    cd Factorial-metrics
>    ```
>
>2. Start the application using Docker.
>    ```bash
>    docker compose up -d
>    ```

## **How to use** 🚀

Once the application is running (and wait a few seconds for everything to start 😅), open your web browser and go to:
```
http://localhost:3000/
```

At this web address you will find the app launched and you can start exploring and testing all its features.

## **Decisions and Trade-offs** 🤝

### **Backend**

- Developed in **`Java`** and **`Spring Boot`** due to my familiarity and experience with this technology. Spring Boot simplifies the configuration and development of Java applications, with strong support for RESTful APIs, security, and data access.

- I followed the **`Hexagonal Architecture`** to create a decoupled system, separating the core logic from external systems like databases. This improves maintainability and testability by isolating the business logic from infrastructure concerns.

- I used **`JPA`** for its powerful ORM capability, simplifying interactions with the database and keeping a clean and modular code.

- I used **`Flyway`** to automate the creation of the database, as well as the insertion of initial data. This ensured that the database schema was always up to date and that the necessary data was available when starting the project.

- **`Lombok`** reduced the repetitive code in Java classes by generating common methods, allowing me to focus more on the business logic.

- **`MapStruct`** was used for mapping objects between DTOs and entities, simplifying conversions and ensuring type safety without unnecessary code.

- For the database management, I chose **`PostgreSQL`** due to my familiarity with it and its reliability. Although I considered specialized time series databases like Prometheus, I opted for PostgreSQL for its robustness and compliance with SQL standards. The Hexagonal Architecture allows for a simple future migration to specialized solutions like Prometheus, if necessary, without requiring extensive refactoring.

- Even though I tried to follow a **`TDD-based approach`**, the tight schedule and the amount of planned tasks made me realize that test coverage should have been more thorough, including more unit tests and integration tests to cover sad paths.

- I considered using virtual threads or a reactive architecture to improve the performance and scalability of the project. However, after analyzing the test requirements and the potential added complexity, I decided they were not necessary. I chose to stick with a more standard and familiar approach, prioritizing simplicity in the implementation.

### **FrontEnd**

- I used **`React`** along with **`TypeScript`** and **`SWC`** for the frontend development. I chose this combination after personally researching on the internet, looking for a modern technological stack that is currently being used for web applications development.

- For state management and API requests, I integrated **[`TanStack Query`](https://tanstack.com/query/latest)**. This library allowed me to easily handle remote data, facilitating the automatic update of the user interface with the latest server data.

- I implemented **[`Recharts`](https://recharts.org/en-US/)** for data visualization, as I found it to be the simplest option to integrate and configure to generate clear and functional charts in the user interface.

- For the quick compilation of the project, I chose **`Vite`** due to its exceptional speed and its ability to provide a smooth and efficient development experience, significantly improving the compilation time.

- Even though I couldn't dedicate time to writing automated tests, I would have liked to use tools like **`Vitest`** for unit testing and **`Playwright`** for end-to-end testing, ensuring the quality of the code and the functionality of the application.

- I used **`Tailwind`** CSS for styles and design, which made it easy to create a stylish user interface.

- Although it was not necessary for this project, in a more professional environment I would consider using **`Mock Service Worker`** to simulate the backend behavior during development, thus avoiding blocking issues between the frontend and the real backend.

## **Things to add or improve** 📝

- Make the graphic responsive.

- Implement testing on both the backend and frontend. This would include unit testing, integration testing and possibly end-to-end testing using tools such as Vitest and Playwright.

- Add functionality to sort the metrics table by column.

- Implement error handling and long load times on the frontend so that the user receives appropriate and understandable feedback, such as displaying an appropriate message in case of errors or long response times.

- Integrate GitHub Actions to automate build, test and deployment tasks.

- Configure backend environments to differentiate between development, test and production.

- Perform architecture tests to verify that the layers defined in the hexagonal architecture are respected.

- Improve exception handling, providing clear messages and appropriate actions to resolve unexpected problems.
