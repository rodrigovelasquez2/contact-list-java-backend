# 📇 Backend-Contact

Sistema **backend** para la gestión de contactos, desarrollado con **Java Spring Boot**.  
Proporciona una **API RESTful** para crear, listar, editar y eliminar contactos, con manejo avanzado de errores y validaciones.

---

## 📝 Descripción
Este proyecto implementa el **backend** de una aplicación de contactos.  
Permite administrar contactos mediante una API REST, siguiendo **buenas prácticas** de arquitectura y desarrollo en Java con Spring Boot.

---

## 🚀 Características principales
- 🔹 API RESTful para operaciones CRUD de contactos.  
- 🔹 Validaciones en DTOs y entidades.  
- 🔹 Manejo de errores centralizado con excepciones personalizadas.  
- 🔹 Separación de capas: controlador, servicio, repositorio, DTO y entidad.  
- 🔹 Pruebas unitarias incluidas.  
- 🔹 Código limpio y mantenible.  

---

## 📦 Dependencias principales
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.modelmapper</groupId>
        <artifactId>modelmapper</artifactId>
        <version>3.2.4</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
</dependencies>
```

# 🔧 Plugins usados
```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
            <annotationProcessorPaths>
                <path>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                </path>
            </annotationProcessorPaths>
        </configuration>
    </plugin>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <excludes>
                <exclude>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                </exclude>
            </excludes>
        </configuration>
    </plugin>
</plugins>
```

# 🛠️ Requisitos previos
- ☕ Java 17+
- 📦 Maven
- 🔗 Git

⚡ Instalación y ejecución

Clonar el repositorio
```
git clone https://github.com/tu-usuario/Backend-Contact.git
cd Backend-Contact
```


Compilar y ejecutar el backend
Existen dos formas:

Desde IntelliJ IDEA (o tu IDE preferido).

Con Maven desde consola:
```
mvn clean install
mvn spring-boot:run
```

# 📂 Estructura del proyecto
```xml
src/
├── main/
│   ├── java/com/rodvels/crud/api/
│   │   ├── ApiApplication.java           # Clase principal
│   │   ├── config/                       # Configuración global (manejo de excepciones)
│   │   ├── controller/                   # Controlador REST
│   │   ├── dto/                          # Data Transfer Objects
│   │   ├── entity/                       # Entidad Contact
│   │   ├── exception/                    # Excepciones personalizadas
│   │   ├── repository/                   # Acceso a datos
│   │   └── service/                      # Lógica de negocio
│   └── resources/
│       └── application.properties        # Configuración de la aplicación
├── test/
│   └── java/com/rodvels/crud/api/
│       └── ApiApplicationTests.java      # Pruebas unitarias
```

🧑‍💻 Buenas prácticas aplicadas

✅ Clean Code: Métodos cortos y descriptivos.
✅ Capas separadas: Controlador, servicio, repositorio, DTO y entidad.
✅ Uso de DTOs: Para transferir datos y proteger entidades.
✅ Validaciones: Anotaciones como @NotNull, @Email, etc.
✅ Manejo de respuestas HTTP: Códigos y mensajes claros.
✅ Excepciones personalizadas: Para errores específicos.

___
📚 Uso del sistema
📋 Listar contactos
```
GET http://localhost:8080/api/contacts
```

Respuesta:
```

[
  {
    "id": 1,
    "name": "User 1",
    "email": "example@gmail.com",
    "created_At": "2025-09-01T21:13:44.700092"
  }
]
```

🔍 Obtener contacto por ID
```
GET http://localhost:8080/api/contacts/4
```

➕ Crear contacto
```
POST http://localhost:8080/api/contacts
```

Body:
```
{
  "name": "Juan Perez",
  "email": "juan@email.com"
}
```
✏️ Editar contacto
```
PUT http://localhost:8080/api/contacts/5
```
🗑️ Eliminar contacto
```
DELETE http://localhost:8080/api/contacts/4
```
