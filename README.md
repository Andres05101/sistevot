# 🏢 Sistevoto - Sistema de Votación para Asambleas de Copropiedades

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.3-green.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Ready-blue.svg)](https://www.docker.com/)

## 📋 Descripción

**Sistevoto** es una aplicación web desarrollada en Spring Boot diseñada específicamente para gestionar asambleas de copropiedades. El sistema permite a los administradores crear asambleas, gestionar votaciones en tiempo real y controlar la asistencia, mientras que los propietarios pueden participar en las votaciones y acceder a documentos relacionados.

## ✨ Características Principales

### 🔐 Autenticación y Autorización
- Sistema de login seguro con Spring Security
- Dos roles principales: **Administrador** y **Propietario**
- Autenticación basada en número de casa y contraseña

### 🏛️ Gestión de Asambleas
- Creación de asambleas con temas específicos
- Control de asistencia en tiempo real
- Subida y descarga de documentos relacionados
- Generación de reportes de asistencia en Excel

### 🗳️ Sistema de Votación
- Creación de preguntas con múltiples opciones de respuesta
- Votaciones con tiempo límite configurable
- Actualización automática de preguntas activas
- Prevención de votos duplicados
- Interfaz en tiempo real (actualización cada 3 segundos)

### 📱 Interfaz de Usuario
- Diseño responsive con Tailwind CSS
- Navegación intuitiva y moderna
- Feedback visual para todas las acciones
- Compatible con dispositivos móviles

## 🏗️ Arquitectura del Sistema

### Stack Tecnológico
- **Backend**: Java 17 + Spring Boot 3.2.3
- **Base de Datos**: MySQL 8.0
- **ORM**: JPA/Hibernate
- **Seguridad**: Spring Security
- **Frontend**: Thymeleaf + Tailwind CSS
- **Contenedorización**: Docker

### Estructura del Proyecto
```
sistevot/
├── src/main/java/com/solucionesvirtual/sistevoto/
│   ├── config/          # Configuración de seguridad
│   ├── controller/      # Controladores REST
│   ├── domain/          # Entidades JPA
│   ├── repository/      # Repositorios de datos
│   ├── service/         # Lógica de negocio
│   └── model/           # Modelos de datos
├── src/main/resources/
│   ├── templates/       # Plantillas Thymeleaf
│   ├── static/          # Archivos estáticos
│   └── application.properties
└── Dockerfile
```

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+
- MySQL 8.0+
- Docker (opcional)

### 1. Clonar el Repositorio
```bash
git clone <url-del-repositorio>
cd sistevot
```

### 2. Configurar Base de Datos
1. Crear una base de datos MySQL
2. Configurar las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistevoto
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Ejecutar la Aplicación

#### Opción A: Con Maven
```bash
mvn clean install
mvn spring-boot:run
```

#### Opción B: Con Docker
```bash
# Construir la imagen
docker build -t sistevoto .

# Ejecutar el contenedor
docker run -p 8090:8090 sistevoto
```

### 4. Acceder a la Aplicación
- **URL**: http://localhost:8090
- **Puerto por defecto**: 8090

## 📖 Guía de Uso

### 👨‍💼 Panel de Administrador

#### Crear una Asamblea
1. Iniciar sesión como administrador
2. En el panel principal, agregar temas a tratar
3. Hacer clic en "Crear Asamblea"

#### Gestionar Votaciones
1. Ir a "Crear votación"
2. Escribir la pregunta y opciones de respuesta
3. Establecer el tiempo límite
4. Guardar la votación

#### Subir Documentos
1. Seleccionar archivo (PDF, DOCX, XLSX, PPTX, TXT)
2. Tamaño máximo: 16MB
3. Hacer clic en "Subir documento"

#### Control de Asistencia
- Ver estadísticas en tiempo real
- Descargar lista de asistentes en Excel
- Monitorear el aforo

### 👤 Panel de Propietario

#### Participar en Asamblea
1. Iniciar sesión con número de casa
2. Firmar asistencia al llegar
3. Ver temas de la asamblea
4. Descargar documentos relacionados

#### Votar
1. Esperar a que aparezcan preguntas activas
2. Seleccionar una opción de respuesta
3. Confirmar el voto
4. Ver resultados en tiempo real

## 🔧 Configuración Avanzada

### Variables de Entorno
```properties
# Base de datos
spring.datasource.url=jdbc:mysql://host:puerto/database
spring.datasource.username=usuario
spring.datasource.password=contraseña

# Servidor
server.port=8090
spring.application.name=sistevoto

# Archivos
spring.servlet.multipart.max-file-size=16MB
spring.servlet.multipart.max-request-size=16MB
```

### Personalización de Seguridad
El sistema utiliza Spring Security con:
- Autenticación basada en formularios
- Roles: `ROLE_ADMIN` y `ROLE_PROPRIETARIO`
- Redirección automática según rol
- Sesiones persistentes

## 📊 Modelo de Datos

### Entidades Principales
- **Copropiedad**: Propiedades/casas con credenciales
- **Asamblea**: Reuniones programadas
- **Tema**: Temas a tratar en asambleas
- **Pregunta**: Preguntas de votación
- **Respuesta**: Opciones de respuesta
- **Voto**: Votos emitidos por propietarios
- **Documento**: Archivos subidos
- **Asamblea_copropiedad**: Control de asistencia

## 🛠️ Desarrollo

### Estructura de Paquetes
```
com.solucionesvirtual.sistevoto
├── config/          # Configuración de seguridad
├── controller/      # Controladores web
├── domain/          # Entidades JPA
├── repository/      # Repositorios
├── service/         # Servicios de negocio
└── model/           # Modelos de datos
```

### Comandos Útiles
```bash
# Compilar proyecto
mvn clean compile

# Ejecutar tests
mvn test

# Generar JAR
mvn package

# Ejecutar con perfil de desarrollo
mvn spring-boot:run -Dspring.profiles.active=dev
```

## 🐛 Solución de Problemas

### Problemas Comunes

#### Error de Conexión a Base de Datos
- Verificar credenciales en `application.properties`
- Asegurar que MySQL esté ejecutándose
- Verificar que la base de datos exista

#### Error de Puerto en Uso
- Cambiar puerto en `application.properties`
- Verificar que no haya otra aplicación usando el puerto 8090

#### Problemas de Autenticación
- Verificar que los usuarios existan en la base de datos
- Comprobar que los roles estén correctamente asignados

## 📝 Logs

Los logs de la aplicación se guardan en `logs.log` en el directorio raíz del proyecto.

## 🤝 Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.
