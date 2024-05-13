# Blog API

This project is an API built using **Java 17, Java Spring, MySQL as the database, JUnit 5 for tests and Spring Security and JWT for authentication control.**

This API was created initially to a blog about science divulgation, but i soon realized that to serve as a backend for a general blog application, providing endpoints for managing blogs and user authentication. 
The API is designed to be easily extensible and can be used as a starting point for building more complex applications. 
However, it is complete enough for you to consume it on your own and create your blog just by doing the frontend.

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Database](#database)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/RamonJales/blog-api.git
```

2. Install dependencies with Maven

3. Install [MySQL](https://www.mysql.com/downloads/)

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /blog - Retrieve a list of all blogs. (all authenticated users)

POST /blog - Register a new blog (ADMIN access required).

POST /auth/login - Login into the App

POST /auth/register - Register a new user into the App
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing blogs (registering new blogs).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

## Database
The project utilizes [MySQL](https://www.mysql.com/) as the database.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.