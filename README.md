# AquaMonitor - Sampling Plans RESTful API

API RESTful desarrollado con Java 25, Spring Boot 4.0.10 y Spring Data JPA (MySQL) para la gestión y registro de planes de muestreo de calidad del agua bajo enfoque Domain-Driven Design (DDD).

## Datos del Estudiante
- **Estudiante:** Sebastian Carbajal Santivanez
- **Código:** u202111461
- **NRC:** 2620
- **Proyecto:** `pc22620u202111461`

## Endpoint Implementado
- `POST /api/v1/sampling-plans` — Registro de nuevos planes de muestreo con validación de dominio, auditoría (`Instant`), patrón `Result` e internacionalización (`en`, `es`, `es-PE`).
