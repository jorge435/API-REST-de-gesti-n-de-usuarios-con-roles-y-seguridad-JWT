# API-REST-de-gestion-de-usuarios-con-roles-y-seguridad-JWT
Construir una API REST con Java Spring Boot que permita:  Registrar y autenticar usuarios  Asignar roles (ADMIN, USER)  Restringir endpoints según el rol  Aplicar seguridad con JWT  Utilizar arquitectura en capas

## Tecnologías
- Java 17
- Spring Boot
- Spring Security + JWT
- MySQL
- JPA/Hibernate

## Funcionalidades
- Registro de usuarios
- Login y generación de token JWT
- Asignación de roles
- Acceso restringido por rol
- CRUD de usuarios

## Endpoints principales
- `POST /auth/register` – Registro
- `POST /auth/login` – Autenticación
- `GET /users` – Obtener lista de usuarios (solo ADMIN)
- `PUT /users/{id}` – Actualizar usuario
- `DELETE /users/{id}` – Eliminar usuario

