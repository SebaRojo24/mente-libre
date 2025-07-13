-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 13-07-2025 a las 03:27:35
-- Versión del servidor: 8.0.40
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mentelibre_mood`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_animo`
--

CREATE TABLE `estado_animo` (
  `id` bigint NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `estado_animo`
--

INSERT INTO `estado_animo` (`id`, `estado`, `fecha`, `usuario_id`) VALUES
(12, 'Triste', '2025-07-03', 1),
(13, 'Conectado', '2025-07-02', 1),
(14, 'Conectado', '2025-07-01', 1),
(15, 'Enojado', '2025-06-30', 1),
(16, 'Conectado', '2025-06-29', 1),
(17, 'Enojado', '2025-07-03', 2),
(18, 'Motivado', '2025-07-02', 2),
(19, 'Triste', '2025-07-01', 2),
(20, 'Ansioso', '2025-06-30', 2),
(21, 'Feliz', '2025-06-29', 2),
(22, 'Ansioso', '2025-07-03', 3),
(23, 'Triste', '2025-07-02', 3),
(24, 'Ansioso', '2025-07-01', 3),
(25, 'Frustrado', '2025-06-30', 3),
(26, 'Agradecido', '2025-06-29', 3),
(27, 'Triste', '2025-07-03', 4),
(28, 'Cansado', '2025-07-02', 4),
(29, 'Enojado', '2025-07-01', 4),
(30, 'Feliz', '2025-06-30', 4),
(31, 'Feliz', '2025-06-29', 4),
(32, 'Ansioso', '2025-07-03', 5),
(33, 'Cansado', '2025-07-02', 5),
(34, 'Agradecido', '2025-07-01', 5),
(35, 'Feliz', '2025-06-30', 5),
(36, 'Motivado', '2025-06-29', 5),
(38, 'Agradecido', '2025-07-03', 999),
(39, 'Agradecido', '2025-07-09', 999);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estado_animo`
--
ALTER TABLE `estado_animo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado_animo`
--
ALTER TABLE `estado_animo`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
