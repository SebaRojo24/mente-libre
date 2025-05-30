Proyecto educativo para aprender Spring Boot y microservicios.

# 🧠 Mente Libre – Plataforma de Bienestar Personal (Microservicios con Spring Boot)

**Mente Libre** es un sistema de bienestar emocional y gestión personal desarrollado con arquitectura de microservicios usando **Spring Boot**, **Eureka**, **Spring Cloud Gateway** y **MySQL**.  
Este proyecto fue construido con fines educativos, orientado a aprender los fundamentos del backend moderno.

---

## 🚀 Tecnologías principales

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Cloud Gateway
- Spring Cloud Eureka
- MySQL (usado con Laragon)
- Maven
- Lombok

---

## 🧩 Microservicios implementados

| Servicio                   | Puerto | Ruta base                 | Descripción breve                                      |
|----------------------------|--------|----------------------------|---------------------------------------------------------|
| `discovery-service`        | 8761   | N/A                        | Registro de microservicios con Eureka                  |
| `gateway-service`          | 8080   | `/api/**`                  | Enrutador de peticiones (proxy Gateway)               |
| `auth-service`             | 8081   | `/api/auth/**`            | Registro y login de usuarios                          |
| `user-profile-service`     | 8082   | `/api/users/**`           | Gestión del perfil del usuario                        |
| `mood-tracker-service`     | 8083   | `/api/moods/**`           | Registro diario del estado de ánimo                   |
| `history-service`          | 8084   | `/api/history/**`         | Consulta del historial de estados de ánimo            |
| `notifications-service`    | 8085   | `/api/notifications/**`   | Recordatorios y notificaciones                        |
| `therapy-chatbot-service`  | 8086   | `/api/chatbot/**`         | Chatbot con respuestas predefinidas                   |
| `report-service`           | 8087   | `/api/reports/**`         | Generación y consulta de reportes simples             |
| `personalization-service`  | 8088   | `/api/personalization/**` | Preferencias visuales y de idioma del usuario         |

---

## 🧠 Funcionalidades destacadas

- Registro y autenticación de usuarios
- Registro de estado de ánimo por día
- Consulta del historial emocional
- Personalización del sistema (idioma, colores, tamaño de texto)
- Comunicación entre servicios mediante Eureka y Gateway
- Persistencia con MySQL, una base de datos por microservicio

---

## 🛠️ Requisitos para correr localmente

1. Java 17
2. Maven
3. MySQL (por ejemplo usando [Laragon](https://laragon.org/))
4. IntelliJ IDEA o VSCode con soporte para Spring Boot
5. Crear las siguientes bases de datos en MySQL:
   - `mentelibre_auth`
   - `mentelibre_user_profile`
   - `mentelibre_mood`
   - `mentelibre_history`
   - `mentelibre_notifications`
   - `mentelibre_reports`
   - `mentelibre_personalization`

---

## ▶️ Ejecución del proyecto

1. Clona este repositorio
2. Abre el proyecto con tu IDE
3. Ejecuta los microservicios en este orden:
   - `discovery-service`
   - `gateway-service`
   - El resto de los servicios en cualquier orden
4. Accede a Eureka en:  
   `http://localhost:8761`
5. Accede a los servicios a través del Gateway:  
   `http://localhost:8080/api/...`

---

## 📬 Ejemplos de endpoints

### Registro de usuario

```http
POST /api/auth/register
{
  "email": "correo@ejemplo.com",
  "password": "1234"
}
