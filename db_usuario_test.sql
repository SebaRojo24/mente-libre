-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:8889
-- Tiempo de generación: 03-07-2025 a las 21:54:11
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
-- Base de datos: `db_usuario_test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `email`, `password`) VALUES
(1, 'jaime.rodrigez@hotmail.com', '$2a$10$ur.z5K5si3oT7YL4hqSmoemY9Eu51KgI.79vQoztLs29OauAVQ5O6'),
(2, 'marcela.blanco@gmail.com', '$2a$10$SvN6DMQZxlk6hxZT4Mgnme4s/VlEc0QTMAFsg1ZFuA/WzwEltQ2QS'),
(3, 'armando.puga@yahoo.com', '$2a$10$CCHIL1HCd42xa8Kf8hMkJem5iNnZ3CJ5ngmlNU2ritdt8AhUPv3HC'),
(4, 'benjamin.montenegro@hotmail.com', '$2a$10$w5B2/jpe5VdgWAe/el4Gh.vPk2TctYjjOvKjiMWnvLyyCXQRXn/mO'),
(5, 'octavio.arteaga@yahoo.com', '$2a$10$9RJUbtROQnFCL9NffKaXAOQBKJdUP0zLsS0pvGLj.dN/q/iFDbilu'),
(6, 'sonia.chavarria@hotmail.com', '$2a$10$NZZaKlj/LNxWib3F4rAsveALg4ypKt16FArU5ObP.ybOUjIncKfe6'),
(7, 'jaime.magana@hotmail.com', '$2a$10$fJLu/qCN/KDA6bgmnkSXhejPIzi3y5i9uEB8XogP4zsHqhCB5b8wu'),
(8, 'clemente.melendez@gmail.com', '$2a$10$JhK6fg3iOjZlnXA6nr1SvuZFM85D6o6RL/QNFvNBWmPhph/Cvm60m'),
(9, 'elisa.olivas@gmail.com', '$2a$10$jU1vSN1qaFzpam7IKvn8MuwYcHR54JOb63H3KvFJCETQnPCsYWyQu'),
(10, 'jorge.frias@yahoo.com', '$2a$10$yIKcGN9PcUMNuSTct0PDueAT9ZKtEDqyunMtiEsyQfFDyYPc7rGly');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
