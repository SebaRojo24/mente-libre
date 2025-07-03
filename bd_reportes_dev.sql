-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 03-07-2025 a las 21:53:52
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
-- Base de datos: `bd_reportes_dev`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reportes`
--

CREATE TABLE `reportes` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `reportes`
--

INSERT INTO `reportes` (`id`, `descripcion`, `fecha`, `usuario_id`) VALUES
(1, 'In qui explicabo velit.', '2025-07-01', 6),
(2, 'Quo quia omnis minus quod.', '2025-06-05', 4),
(3, 'Sequi vel dolor.', '2025-06-04', 3),
(4, 'Labore est et vel eius.', '2025-06-25', 1),
(5, 'Fugit quia dolor nihil veniam animi.', '2025-06-23', 5),
(6, 'Omnis repudiandae maiores.', '2025-06-15', 2),
(7, 'Maxime eveniet sunt animi reiciendis at ut.', '2025-06-19', 7),
(8, 'Magnam consequatur laboriosam sequi quis.', '2025-06-20', 4),
(9, 'Voluptatem quia qui totam.', '2025-06-09', 3),
(10, 'Est perferendis perspiciatis impedit rerum.', '2025-06-11', 2),
(11, 'Ipsum cupiditate quia asperiores alias.', '2025-06-04', 9),
(12, 'Repellat est voluptatem.', '2025-07-03', 8),
(13, 'Fuga culpa deserunt voluptas.', '2025-06-17', 8),
(14, 'Minima accusantium error illum.', '2025-06-08', 6),
(15, 'Omnis cumque nulla.', '2025-06-11', 8),
(16, 'Itaque rem nesciunt perferendis fugiat modi.', '2025-06-29', 2),
(17, 'Et dolores exercitationem iste deserunt molestias libero autem.', '2025-06-22', 4),
(18, 'Deserunt sed dolorem nulla ut.', '2025-06-12', 7),
(19, 'Dicta eos exercitationem consectetur laudantium.', '2025-06-20', 3),
(20, 'Et molestias voluptates hic labore adipisci aspernatur.', '2025-06-15', 6),
(21, 'Aliquid rerum vel deserunt consequatur voluptas veritatis non.', '2025-07-03', 4),
(22, 'Aut magni eum.', '2025-06-10', 3),
(23, 'Sed voluptatibus doloribus sunt.', '2025-06-21', 6),
(24, 'Perferendis similique velit et nulla eveniet cum.', '2025-06-12', 8),
(25, 'Fugit voluptatem aut sunt est ducimus quia.', '2025-06-08', 4),
(26, 'Recusandae quia vitae placeat animi.', '2025-07-03', 4),
(27, 'Facilis perferendis rerum et ducimus.', '2025-06-30', 3),
(28, 'Delectus ipsam delectus placeat eos ea ut aspernatur.', '2025-06-19', 3),
(29, 'Amet id libero ab sit ad non.', '2025-06-22', 2),
(30, 'Sit laborum ut qui.', '2025-06-28', 2),
(31, 'Magnam optio et odit repellendus voluptas corrupti.', '2025-06-05', 2),
(32, 'Et assumenda dolor cum deserunt animi.', '2025-07-01', 9),
(33, 'Blanditiis placeat aut.', '2025-06-29', 3),
(34, 'Ut ea odio.', '2025-06-12', 7),
(35, 'Quia id voluptas asperiores.', '2025-06-05', 5),
(36, 'Culpa nihil error vel rerum quisquam quaerat.', '2025-06-05', 3),
(37, 'A suscipit quasi maiores illum qui.', '2025-06-22', 7),
(38, 'Qui neque adipisci.', '2025-06-25', 3),
(39, 'Adipisci consectetur exercitationem ipsam.', '2025-07-02', 2),
(40, 'Sint earum non maxime excepturi.', '2025-06-14', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reportes`
--
ALTER TABLE `reportes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reportes`
--
ALTER TABLE `reportes`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
