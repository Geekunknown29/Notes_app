# Notes Manager

Spring Boot notes app with Thymeleaf, Spring Security, JPA, and MySQL.

## Deploy on Railway

This repo includes `railway.toml`, so Railway can build and start the app from the repository.

1. Push this project to GitHub.
2. In Railway, create a new project and choose **Deploy from GitHub repo**.
3. Add a MySQL database service in the same Railway project.
4. In the app service, add these variables:

```text
APP_USERNAME=your-login-username
APP_PASSWORD=your-login-password
```

Railway's MySQL service provides these automatically:

```text
MYSQLHOST
MYSQLPORT
MYSQLUSER
MYSQLPASSWORD
MYSQLDATABASE
```

5. Open the app service's **Networking** settings and generate a public domain.

The app listens on Railway's `PORT` variable and exposes `/health` for Railway health checks.
