
# Sistema Médico - Backend + Frontend

Trabajo práctico final de Programación Web - Backend  
Profesor: Ing. Gustavo Sosa Cataldo

## 🧩 Descripción

Aplicación web para gestión de pacientes, médicos y fichas clínicas.  
Incluye backend Java EE y frontend en HTML/JS.

## ⚙️ Tecnologías usadas

- Java 8  
- JEE: JAX-RS (REST), JPA (Hibernate), EJB  
- PostgreSQL 16  
- Wildfly 18.0.1  
- Maven  
- Frontend: HTML5, JavaScript, CSS, Fetch API  

## 🧱 Módulos implementados

### ✅ Pacientes
- CRUD completo (`/api/pacientes`)
- Vista web: `pacientes.html`

### ✅ Médicos
- CRUD completo (`/api/medicos`)
- Login (`/api/medicos/login`)
- Vista web: `index.html`, `medicos.html`

### ✅ Fichas clínicas
- Crear ficha (`/api/fichas`)
- Ver historial con filtros (`/api/fichas/filtrar`)
- Vista web: `fichas.html`, `historial.html`

## ▶️ Cómo ejecutar

1. Asegurarse de tener PostgreSQL con la base `clinica` y el datasource en Wildfly:
   ```
   java:jboss/datasources/clinica
   ```

2. Correr Wildfly con `standalone.bat`  
3. Hacer `mvn clean install`  
4. Deployar el `clinica-backend.war` en `standalone/deployments/`  
5. Acceder desde navegador:

```
http://localhost:8080/clinica-backend/index.html
```

## 👨‍⚕️ Usuarios de prueba

```json
Médico:
Username: laura
Password: 1234
```

## 📝 Autores

- Jose Ramirez
- [https://github.com/joseram03](https://github.com/joseram03)
