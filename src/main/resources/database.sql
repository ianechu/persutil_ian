-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 10-11-2025 a las 11:28:03
-- Versión del servidor: 8.4.5
-- Versión de PHP: 8.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `persutildb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sempertegui_pelicula`
--

CREATE TABLE `sempertegui_pelicula` (
  `id` BIGINT NOT NULL AUTO_INCREMENT , 
  `nombre` VARCHAR(255) NOT NULL , 
  `genero` VARCHAR(255) NOT NULL , 
  `director` VARCHAR(255) NOT NULL , 
  `puntuacion` INT NOT NULL , 
  `anyo` YEAR NOT NULL , 
  `fecha_creacion` DATETIME NOT NULL , 
  `fecha_modificacion` DATETIME DEFAULT NULL , 
  PRIMARY KEY (`id`), 
  UNIQUE `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Estructura de tabla para la tabla `blog`
--

CREATE TABLE `blog` (
  `id` bigint NOT NULL,
  `titulo` varchar(1024) COLLATE utf32_unicode_ci NOT NULL,
  `contenido` longtext COLLATE utf32_unicode_ci NOT NULL,
  `etiquetas` varchar(1024) COLLATE utf32_unicode_ci NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;



--
-- Estructura tabla pallas(notas)
--

CREATE TABLE `pallas` (
  `id` bigint NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `contenido` longtext,
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `publicado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Índices de la tabla `pallas`

ALTER TABLE `pallas`
  ADD PRIMARY KEY (`id`);

--AUTO_INCREMENT de la tabla `pallas`
ALTER TABLE `pallas`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;
COMMIT;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alfonso_respuesta`
--

CREATE TABLE `alfonso_respuesta` (
  `id` bigint NOT NULL,
  `autor` varchar(128) COLLATE utf32_unicode_ci NOT NULL,
  `contenido` longtext COLLATE utf32_unicode_ci NOT NULL,
  `publicado` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `alfonso_respuesta`
--
ALTER TABLE `alfonso_respuesta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `blog`
--
ALTER TABLE `blog`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE `tarea` (
  `id` bigint NOT NULL,
  `titulo` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  `descripcion` text COLLATE utf32_unicode_ci,
  `categoria` varchar(100) COLLATE utf32_unicode_ci DEFAULT NULL,
  `completada` tinyint(1) NOT NULL DEFAULT '0',
  `publicado` tinyint(1) NOT NULL DEFAULT '1',
  `fecha_creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id`, `titulo`, `descripcion`, `categoria`, `completada`, `publicado`, `fecha_creacion`, `fecha_modificacion`) VALUES
(1, 'Hacer ejercicio en base de datos #1', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T09:53:50', 'Viajes', 0, 1, '2025-11-27 09:53:50', '2025-11-27 09:53:50'),
(2, 'Practicar entrenamiento #2', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T09:53:50', 'Compras', 0, 1, '2025-11-27 09:53:50', '2025-11-27 09:53:50'),
(3, 'Leer sobre equipo #3', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T09:53:50', 'Estudios', 1, 1, '2025-11-27 09:53:50', '2025-11-27 09:53:50'),
(4, 'Leer sobre equipo #4', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T09:53:50', 'Deporte', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(5, 'Preparar casa #5', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T09:53:50', 'Salud', 1, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(6, 'Configurar reunión #6', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T09:53:50', 'Viajes', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(7, 'Estudiar cita médica #7', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T09:53:50', 'Estudios', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(8, 'Planificar reunión #8', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T09:53:50', 'Deporte', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(9, 'Planificar curso #9', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T09:53:50', 'Deporte', 1, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(10, 'Organizar presentación #10', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T09:53:51', 'Familia', 1, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(11, 'Leer sobre calendario #11', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T09:53:51', 'Trabajo', 1, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(12, 'Actualizar presupuesto #12', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T09:53:51', 'Casa', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(13, 'Practicar entrenamiento #13', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T09:53:51', 'Casa', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(14, 'Aprender servidor #14', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T09:53:51', 'Viajes', 0, 1, '2025-11-27 09:53:51', '2025-11-27 09:53:51'),
(15, 'Revisar portfolio #15', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T09:53:51', 'Casa', 0, 1, '2025-11-27 09:53:52', '2025-11-27 09:53:52'),
(16, 'Planificar entrenamiento #16', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T09:53:51', 'Familia', 1, 1, '2025-11-27 09:53:52', '2025-11-27 09:53:52'),
(17, 'Leer sobre curriculum #17', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T09:53:51', 'Estudios', 1, 1, '2025-11-27 09:53:52', '2025-11-27 09:53:52'),
(18, 'Planificar presupuesto #18', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T09:53:51', 'Casa', 0, 1, '2025-11-27 09:53:52', '2025-11-27 09:53:52'),
(19, 'Leer sobre entrenamiento #19', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T09:53:51', 'Salud', 1, 1, '2025-11-27 09:53:52', '2025-11-27 09:53:52'),
(20, 'Hacer ejercicio en el GIMNASIO #20', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T09:53:51', 'Viajes.', 0, 1, '2025-11-27 09:53:52', '2025-11-27 09:15:50'),
(21, 'Llamar a portfolio #1', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:19', 'Trabajo', 0, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(22, 'Estudiar calendario #2', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:20', 'Tecnología', 1, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(23, 'Llamar a base de datos #3', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:20', 'Deporte', 0, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(24, 'Llamar a documentación #4', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T10:21:20', 'Viajes', 0, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(25, 'Estudiar informe #5', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T10:21:20', 'Deporte', 1, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(26, 'Planificar base de datos #6', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T10:21:20', 'Familia', 0, 1, '2025-11-27 10:21:20', '2025-11-27 10:21:20'),
(27, 'Planificar aplicación #7', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T10:21:20', 'Estudios', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(28, 'Limpiar curso #8', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:20', 'Familia', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(29, 'Terminar proyecto de examen #9', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:21', 'Familia', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(30, 'Aprender sistema #10', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T10:21:21', 'Casa', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(31, 'Limpiar presupuesto #11', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:21', 'Viajes', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(32, 'Estudiar curriculum #12', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:21', 'Compras', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(33, 'Configurar presupuesto #13', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:21', 'Deporte', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(34, 'Terminar proyecto de examen #14', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:21', 'Hobby', 0, 1, '2025-11-27 10:21:21', '2025-11-27 10:21:21'),
(35, 'Organizar examen #15', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:21', 'Hobby', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(36, 'Comprar presupuesto para el Erasmus #16', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T10:21:21', 'Familia', 0, 1, '2025-11-27 10:21:22', '2025-11-27 09:22:06'),
(37, 'Llamar a examen #17', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T10:21:21', 'Deporte', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(38, 'Estudiar calendario #18', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:21', 'Trabajo', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(39, 'Hacer ejercicio en documentación #19', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T10:21:22', 'Viajes', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(40, 'Llamar a aplicación #20', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:22', 'Tecnología', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(41, 'Organizar sistema #21', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:22', 'Salud', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(42, 'Llamar a calendario #22', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:22', 'Salud', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(43, 'Limpiar curriculum #23', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T10:21:22', 'Deporte', 0, 1, '2025-11-27 10:21:22', '2025-11-27 10:21:22'),
(44, 'Aprender portfolio #24', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:22', 'Familia', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(45, 'Llamar a informe #25', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T10:21:22', 'Trabajo', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(46, 'Llamar a cita médica #26', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:22', 'Estudios', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(47, 'Comprar presentación #27', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T10:21:22', 'Tecnología', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(48, 'Revisar sistema #28', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:22', 'Compras', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(49, 'Planificar documentación #29', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:22', 'Estudios', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(50, 'Practicar calendario #30', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:23', 'Familia', 1, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(51, 'Hacer ejercicio en presentación #31', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T10:21:23', 'Trabajo', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(52, 'Hacer ejercicio en entrenamiento #32', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:23', 'Familia', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(53, 'Llamar a examen #33', 'Esta es una tarea importante que requiere atención inmediata. Generada automáticamente el 2025-11-27T10:21:23', 'Salud', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(54, 'Llamar a presentación #34', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:23', 'Compras', 0, 1, '2025-11-27 10:21:23', '2025-11-27 10:21:23'),
(55, 'Aprender presupuesto #35', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:23', 'Tecnología', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(56, 'Leer sobre examen #36', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:23', 'Viajes', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(57, 'Planificar presupuesto #37', 'Tarea programada para completar durante esta semana. Generada automáticamente el 2025-11-27T10:21:23', 'Casa', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(58, 'Estudiar aplicación #38', 'Actividad opcional pero recomendable para el desarrollo personal. Generada automáticamente el 2025-11-27T10:21:23', 'Hobby', 1, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(59, 'Estudiar servidor #39', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:23', 'Casa', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(60, 'Llamar a examen #40', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T10:21:24', 'Compras', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(61, 'Planificar cita médica #41', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:24', 'Estudios', 0, 1, '2025-11-27 10:21:24', '2025-11-27 10:21:24'),
(62, 'Leer sobre portfolio #42', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:24', 'Familia', 1, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(63, 'Organizar proyecto #43', 'Actividad de seguimiento que debe realizarse periódicamente. Generada automáticamente el 2025-11-27T10:21:24', 'Hobby', 1, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(64, 'Llamar a equipo #44', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:24', 'Estudios', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(65, 'Limpiar oficina #45', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:24', 'Casa', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(66, 'Preparar curriculum #46', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:21:24', 'Deporte', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(67, 'Revisar examen #47', 'Proyecto a largo plazo que necesita planificación detallada. Generada automáticamente el 2025-11-27T10:21:24', 'Compras', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(68, 'Practicar entrenamiento #48', 'Tarea urgente con alta prioridad de ejecución. Generada automáticamente el 2025-11-27T10:21:25', 'Trabajo', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(69, 'Revisar documentación #49', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:25', 'Tecnología', 0, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(70, 'Leer sobre calendario #50', 'Proyecto individual que requiere concentración y dedicación. Generada automáticamente el 2025-11-27T10:21:25', 'Casa', 1, 1, '2025-11-27 10:21:25', '2025-11-27 10:21:25'),
(71, 'Terminar proyectos de equipo #1', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:33:00', 'Deporte', 0, 1, '2025-11-27 09:33:00', '2025-11-27 09:35:15'),
(72, 'Revisar entrenamiento #2', 'Tarea colaborativa que involucra a varios miembros del equipo. Generada automáticamente el 2025-11-27T10:33:00', 'Tecnología', 0, 1, '2025-11-27 09:33:00', NULL);
-- --------------Joan Salinas------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` bigint NOT NULL,
  `nombre` varchar(1024) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `ingredientes` longtext CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `preparacion` longtext CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
CREATE TABLE `alcalde` (
  `id` bigint NOT NULL,
  `titulo` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  `autor` varchar(255) COLLATE utf32_unicode_ci NOT NULL,
  `genero` varchar(100) COLLATE utf32_unicode_ci NOT NULL,
  `reseña` longtext COLLATE utf32_unicode_ci NOT NULL,
  `valoracion` int NOT NULL,
  `publicado` tinyint(1) NOT NULL DEFAULT '1',
  `destacado` tinyint(1) NOT NULL DEFAULT '0',
  `fecha_lectura` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

ALTER TABLE `alcalde`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `alcalde`
--
-- AUTO_INCREMENT de la tabla `alfonso_respuesta`
--
ALTER TABLE `alfonso_respuesta`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;
COMMIT;


-- Pollyanna --


CREATE TABLE `soares` (
  `id` bigint NOT NULL,
  `preguntas` varchar(255) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_modificacion` datetime DEFAULT NULL,
  `publicacion` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tarea`
--
ALTER TABLE `tarea`
-- Indices de la tabla `soares`
--
ALTER TABLE `soares`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tarea`
--
ALTER TABLE `tarea`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

-- AUTO_INCREMENT de la tabla `soares`
--
ALTER TABLE `soares`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3137;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;