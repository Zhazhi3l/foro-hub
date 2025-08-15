<h1>🗣️ Foru Hub</h1> 

<p align="center">
  <img src="https://img.shields.io/badge/ESTADO-EN%20DESARROLLO-yellow">
  <img src="https://img.shields.io/badge/VERSIÓN-1.0.0-blue">
</p>

## Tabla de Contenidos
1. [Introducción](#introducción)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Características](#características)
4. [Instalación y Configuración](#instalación-y-configuración)
5. [Tecnologías Utilizadas](#tecnologías-utilizadas)
6. [Uso de la API](#uso-de-la-api)
7. [Autor](#autor)

---

## Introducción
ForumHub es una aplicación de foro desarrollada en **Java** usando **Spring Boot** y **Spring Framework**, diseñada para gestionar tópicos de discusión. Los usuarios pueden crear tópicos, autenticarse mediante tokens JWT, y la aplicación se conecta a una base de datos MySQL gestionada con **Flyway** para migraciones.

El proyecto está organizado de manera modular siguiendo principios de **programación orientada a objetos**, lo que facilita su mantenimiento y escalabilidad.

---

## Estructura del Proyecto

src/
└── main/
├── java/
│ └── com/
│ └── hazzav/
│ └── foro_hub/
│ ├── controller/
│ │ └── TopicosController.java # Controladores REST que exponen los endpoints
│ ├── domain/
│ │ ├── topico/
│ │ │ ├── Topico.java
│ │ │ ├── TopicoRepository.java
│ │ │ └── (DTOs como DatosRegistroTopico, etc.)
│ │ └── usuario/
│ │ ├── Usuario.java
│ │ ├── UsuarioRepository.java
│ │ ├── AutenticacionService.java
│ │ └── (DTOs como DatosAutenticacion, etc.)
│ ├── infra/
│ │ └── security/
│ │ ├── SecurityConfiguration.java
│ │ ├── SecurityFilter.java
│ │ └── TokenService.java
│ └── ForoHubApplication.java # Punto de entrada de la aplicación
└── resources/
└── application.properties # Configuración de Spring Boot

pom.xml # Dependencias y build del proyecto

## Características

### Funcionalidades Principales
- Creación y gestión de tópicos en un foro
- Registro y autenticación de usuarios
- Validación y manejo de roles de usuario
- Seguridad mediante **Spring Security** y **JWT**
- Migraciones y gestión de base de datos con **Flyway**

### Características Técnicas
- Arquitectura modular
- Separación de capas (controller, domain, infra)
- Uso de DTOs para transferencia de datos
- Facilidad de extensión para nuevas funcionalidades

---

## Instalación y Configuración

### Requisitos Previos
- Java JDK 21 o superior
- IDE compatible con Java (recomendado: IntelliJ IDEA, Eclipse)
- MySQL (o compatible)

### Pasos de Instalación
1. Clona el repositorio:
```
git clone https://github.com/Zhazhi3l/ForumHub.git
```
Abre el proyecto en tu IDE.

Configura la conexión a la base de datos en application.properties.

### Tecnologías Utilizadas
- Java 21
- Spring Boot
- Spring Security con JWT
- MySQL + Flyway
- Maven
- DTOs y programación orientada a objetos

### Uso de la API
#### Endpoints principales
##### Tópicos

POST /topicos → Crear un nuevo tópico

GET /topicos → Listar todos los tópicos

GET /topicos/{id} → Obtener un tópico específico

##### Usuarios

POST /usuarios → Registrar nuevo usuario

POST /auth/login → Autenticación y obtención de token JWT

💡 Recuerda que algunas rutas requieren autenticación con token JWT en el header Authorization.

Ejemplo de Request con cURL
### Crear Tópico

```
{
    "titulo": "Mi primer tópico",
    "mensaje": "Contenido del tópico",
    "curso": "Java",
    "estado": "abierto"
}
```

### Autenticación de Usuario
```
{
    "login": "usuario@example.com",
    "contrasena": "contraseña123"
}

```

## 💡 Autor
Visita mi perfil en LinkedIn

<div align="center"> <img src="https://upload.wikimedia.org/wikipedia/commons/c/ca/LinkedIn_logo_initials.png" alt="LinkedIn Logo" width="50"> </div>
