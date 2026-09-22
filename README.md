# Filtro Java — Gestión de ninjas y misiones

Aplicación de consola en **Java** conectada a **MySQL** mediante **JDBC**, organizada con una arquitectura **MVC + DAO**. Permite administrar ninjas, sus habilidades y las misiones que se les asignan.

## Arquitectura

```
src/
  Model/        Ninja · Mision · Habilidad
  DAO/          NinjaDAO · MisionDAO · HabilidadDAO   (acceso a datos con JDBC)
  Controller/   Lógica de cada entidad
  View/         Menús de consola
  DataBase/     Conexion (configurada desde config.properties)
  Main/         Punto de entrada y menú principal
Tablas_filtro.sql   Script de la base de datos
```

## Modelo de datos

Tablas `Ninja`, `Habilidad`, `Mision` y la tabla intermedia `MisionNinja` (relación muchos a muchos entre ninjas y misiones).

## Ejecutar

1. Crea la base de datos con `Tablas_filtro.sql`.
2. Ajusta los datos de conexión en `config.properties`.
3. Abre el proyecto en NetBeans (o compílalo con Ant usando `build.xml`) y ejecuta `Main`.

## Stack

`Java` · `JDBC` · `MySQL` · `MVC` · `DAO`
