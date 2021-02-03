-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-02-2021 a las 01:29:48
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `hospital`
--
CREATE DATABASE `hospital` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hospital`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historias_clinicas`
--

CREATE TABLE IF NOT EXISTS `historias_clinicas` (
  `numero_h` varchar(10) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `documento` varchar(15) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `tipo_afiliacion` varchar(6) NOT NULL,
  `servicio` varchar(15) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `historias_clinicas`
--

INSERT INTO `historias_clinicas` (`numero_h`, `fecha`, `nombre`, `documento`, `direccion`, `telefono`, `tipo_afiliacion`, `servicio`, `valor`) VALUES
('12343', '2/2/2021', 'prueba bd', '01245778844', 'dirreccionnnn', '1324567898', 'C', 'Vacunacion', 20000),
('3412122', '2/2/2021', 'labsprueba', '3124325435546', 'adsdadsddddwww', '4344343443', 'S', 'Laboratorios', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
