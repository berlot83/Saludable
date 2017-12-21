-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2017 a las 15:23:59
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `utn`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacient`
--

CREATE TABLE `pacient` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `dni` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `genre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pacient`
--

INSERT INTO `pacient` (`id`, `name`, `lastname`, `birthday`, `dni`, `age`, `telephone`, `email`, `city`, `genre`) VALUES
(64, 'Axel', 'asdasd', '2001-10-12', 345345345, 16, '234234', 'sdfsdf', 'sdfsdf', 'sdfsdf'),
(65, 'Axel', 'hjk', '2001-10-12', 123234345, 16, '567567', 'ghj', 'ghj', 'ghj'),
(66, 'Axel', 'werwer', '2001-10-12', 22342344, 16, '234', 'wdrf', 'wer', 'we'),
(67, 'Axel', 'Berlot', '2001-10-12', 30158619, 16, '1553189339', 'berlot83@yahoo.com.ar', 'Caba', 'Masculino'),
(68, 'Dana', 'Berlot', '2001-10-12', 44274488, 16, '1553189339', 'dana07@yahoo.com.ar', 'Caba', 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `user`, `password`) VALUES
(1, 'user1', '1234'),
(2, 'user2', '1234'),
(3, 'Axel', '1234'),
(4, 'Alexis', '1234'),
(8, 'user3', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pacient`
--
ALTER TABLE `pacient`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pacient`
--
ALTER TABLE `pacient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
