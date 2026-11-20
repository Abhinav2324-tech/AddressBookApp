# Address Book App

A Spring Boot REST API for managing contacts. Each contact has an automatically assigned ID, a name, a phone number, and a city. The API supports creating, listing, retrieving, updating, and deleting contacts.

[View the application code on the `develop` branch](https://github.com/Abhinav2324-tech/AddressBookApp/tree/develop)

## Features

- Create contacts and look them up by ID.
- Update a contact’s name, phone number, or city without changing its ID.
- Delete contacts and return `404 Not Found` when a requested ID doesn’t exist.
- Return successful responses as JSON with `message` and `data` fields.

Contacts are stored **in memory** and reset when the application restarts. MySQL connectivity is configured, but contacts are not saved to MySQL in this version.

## Tech Stack

Java 17, Spring Boot, Spring Web, Spring Data JPA, MySQL Connector/J, Maven, and `curl`.

| Package | Responsibility |
| --- | --- |
| `controller` | Handles HTTP requests and builds JSON responses. |
| `service` | Manages contact operations and the in-memory list. |
| `dto` | Defines the request and response objects. |
| `model` | Represents a contact and its fields. |

## Run Locally

1. Clone the `develop` branch in Git Bash:

   ```bash
   git clone --branch develop https://github.com/Abhinav2324-tech/AddressBookApp.git
   cd AddressBookApp
   ```

2. Start your local MySQL server and create the database:

   ```sql
   CREATE DATABASE IF NOT EXISTS addressbook_service;
   ```

3. The app connects to MySQL on `localhost:3306` and uses `root` by default. If you use a different MySQL account, run `export DB_USERNAME='your_mysql_username'`. Then enter your password and start the app:

   ```bash
   read -rsp 'MySQL password: ' DB_PASSWORD
   echo
   export DB_PASSWORD
   ./mvnw spring-boot:run
   ```

4. Leave the app running and verify it from a second terminal:

   ```bash
   curl -i http://localhost:8080/addressbook/health
   ```

   The health endpoint should return `200 OK` with `{"status":"UP"}`.

## API Endpoints

| Method | Endpoint | Purpose |
| --- | --- | --- |
| `GET` | `/addressbook/health` | Check whether the application is running. |
| `GET` | `/addressbook/` | List all contacts. |
| `GET` | `/addressbook/get/{contactId}` | Retrieve a contact by ID. |
| `POST` | `/addressbook/create` | Create a contact. |
| `PUT` | `/addressbook/update/{contactId}` | Update an existing contact by ID. |
| `DELETE` | `/addressbook/delete/{contactId}` | Delete a contact by ID. |

### Example Request

```bash
curl -i -X POST http://localhost:8080/addressbook/create \
  -H 'Content-Type: application/json' \
  -d '{"name":"Lisa","phone":"9876543210","city":"Chennai"}'
```

Use the `contactId` from the response to retrieve, update, or delete the contact. Send the same three fields in the JSON body when updating a contact.

## Development Workflow

| Use case | Implementation |
| --- | --- |
| Section 1 UC 1 | Set up the Spring Boot project and verify the health endpoint. |
| Section 1 UC 2 | Configure MySQL and add the REST controller. |
| Section 2 UC 1 | Add the contact model and request and response DTOs. |
| Section 2 UC 2 | Move contact operations into the service layer. |
| Section 2 UC 3 | Implement and test in-memory CRUD. |

Each use case was implemented on a separate feature branch and merged into `develop`. The `main` branch contains only this README.
