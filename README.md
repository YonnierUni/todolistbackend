# GitHubYonnierUni-Ensolvers-Challenge
Project To-Do List

This project is a To-Do List application that utilizes technologies in both the backend and frontend to create and manage tasks.

Backend

The backend of the application is built using the following technologies:

Java: I use Java version 20 as the main programming language.

Maven: Maven is used as the build system and dependency management tool.

Spring Boot: I have employed Spring Boot version 3.1.3 as the primary framework for backend development.

Flyway: I use Flyway version 9.16.3 to manage database migrations.

PostgreSQL: The backend database is PostgreSQL, used to store tasks and their details.

JPA: I have opted for JPA (Java Persistence API) for handling entities and their persistence in the database.

Frontend

The frontend of the application is built using the following technologies:

React: I use React version 18.2.0 as the main library to build the user interface.

React Router Dom: React Router Dom version 6.15.0 is used to manage routes and navigation within the application.

React Icons: I use React Icons version 4.10.1 to incorporate icons into the user interface.

Testing Library: For unit testing, I have used Testing Library libraries including @testing-library/react, @testing-library/jest-dom, and @testing-library/user-event.

Installation

Backend: To set up the backend of the application, make sure you have Java 20 and Maven installed. Run Flyway migrations to set up the database. Ensure you have a PostgreSQL database available and configure credentials in the configuration file.
Clarify that it is necessary to have the following environment variables according to their use:
UserPostgres={user};
Password={password};
NameDB={project_to_do_list_db};

Frontend: To set up the frontend, make sure you have Node.js installed. Run npm install in the project folder to install dependencies. Then, you can run npm start to launch the application in your browser.

Usage

In the frontend, you can add and manage your pending tasks.
The backend provides the logic to manage tasks in the database and performs necessary CRUD operations.
