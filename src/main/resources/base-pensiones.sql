-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2023 a las 16:41:40
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base-pensiones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calculo_actuarial`
--

CREATE TABLE `calculo_actuarial` (
  `id_calculo` int(11) NOT NULL,
  `auxilio_funerario` decimal(19,2) DEFAULT NULL,
  `d1` int(11) DEFAULT NULL,
  `d2` int(11) DEFAULT NULL,
  `edad_fecha_corte` int(11) DEFAULT NULL,
  `edad_referencia` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `factora_actuarial1` decimal(19,2) DEFAULT NULL,
  `factora_actuarial2` decimal(19,2) DEFAULT NULL,
  `factor_actuarial3` decimal(19,2) DEFAULT NULL,
  `fecha_convalidacion` double DEFAULT NULL,
  `fecha_corte` date DEFAULT NULL,
  `fecha_inicio_no_pago` date DEFAULT NULL,
  `fecha_referencia` date DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `id_empleador` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `numero_salarios_minimos` decimal(19,2) DEFAULT NULL,
  `pension_referencia` decimal(19,2) DEFAULT NULL,
  `proximo_cumpleanos` date DEFAULT NULL,
  `reserva_acturial` decimal(19,2) DEFAULT NULL,
  `salario_minimo_fecha_corte` double DEFAULT NULL,
  `salario_referencia` decimal(19,2) DEFAULT NULL,
  `smn_interpolado` bigint(20) DEFAULT NULL,
  `tasa_reemplazo` double DEFAULT NULL,
  `tiempo_faltante_pension` double DEFAULT NULL,
  `ultimo_cumpleanos` date DEFAULT NULL,
  `v1` double DEFAULT NULL,
  `v2` double DEFAULT NULL,
  `tiempo_convalidacion` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calculo_actuarial`
--

INSERT INTO `calculo_actuarial` (`id_calculo`, `auxilio_funerario`, `d1`, `d2`, `edad_fecha_corte`, `edad_referencia`, `estado`, `factora_actuarial1`, `factora_actuarial2`, `factor_actuarial3`, `fecha_convalidacion`, `fecha_corte`, `fecha_inicio_no_pago`, `fecha_referencia`, `fecha_registro`, `id_empleado`, `id_empleador`, `id_usuario`, `numero_salarios_minimos`, `pension_referencia`, `proximo_cumpleanos`, `reserva_acturial`, `salario_minimo_fecha_corte`, `salario_referencia`, `smn_interpolado`, `tasa_reemplazo`, `tiempo_faltante_pension`, `ultimo_cumpleanos`, `v1`, `v2`, `tiempo_convalidacion`) VALUES
(1, 5800000.00, 176, 189, 35, 62, 'Anulado', 235.98, 0.46, 0.05, NULL, '2019-04-20', '2017-05-04', '2045-10-26', '2023-08-28 15:07:22', 1, 1, 1, 5.07, 2359846.69, '2019-10-26', 25276021.00, 828116, 3747924.13, 0, 62.9641, 26.518822724161534, '2018-10-26', 0, 2.777921, 1.960301),
(2, 5800000.00, 176, 189, 35, 62, 'Exitoso', 235.98, 0.46, 0.05, NULL, '2019-04-20', '2017-05-04', '2045-10-26', '2023-08-28 15:07:32', 3, 4, 1, 5.07, 2359846.69, '2019-10-26', 25276021.00, 828116, 3747924.13, 0, 62.9641, 26.518822724161534, '2018-10-26', 0, 2.777921, 1.960301),
(3, 5800000.00, 6, 360, 28, 57, 'Anulado', 235.98, 0.33, 0.03, NULL, '2019-09-25', '2018-01-17', '2048-09-19', '2023-08-28 15:09:37', 1, 3, 1, 1.33, 879835.82, '2020-09-19', 7257114.00, 828116, 1357020.57, 0, 64.83585, 28.985626283367555, '2019-09-19', 0, 2.310209, 1.686516),
(4, 5800000.00, 6, 360, 28, 57, 'Anulado', 235.98, 0.33, 0.03, NULL, '2019-09-25', '2018-01-17', '2048-09-19', '2023-08-28 15:24:48', 4, 9, 1, 10.87, 6669065.25, '2020-09-19', 54567963.00, 828116, 11102895.57, 0, 60.066, 28.985626283367555, '2019-09-19', 0, 2.310209, 1.686516),
(5, 5800000.00, 213, 152, 26, 62, 'Anulado', 235.98, 0.46, 0.03, NULL, '2019-04-20', '2017-05-04', '2054-09-19', '2023-08-28 15:32:06', 5, 4, 1, 5.07, 3095698.19, '2019-09-19', 21666211.00, 828116, 4916608.34, 0, 62.9641, 35.41683778234086, '2018-09-19', 0, 2.154318, 1.960301),
(6, 5800000.00, 6, 360, 28, 57, 'Exitoso', 235.98, 0.33, 0.03, NULL, '2019-09-25', '2018-01-17', '2048-09-19', '2023-08-30 18:01:22', 4, 8, 2, 1.33, 879835.82, '2020-09-19', 7257114.00, 828116, 1357020.57, 0, 64.83585, 28.985626283367555, '2019-09-19', 0, 2.310209, 1.686516),
(7, 5800000.00, 6, 360, 28, 57, 'Exitoso', 235.98, 0.33, 0.03, NULL, '2019-09-25', '2018-01-17', '2048-09-19', '2023-08-31 14:59:14', 4, 4, 1, 10.87, 6669065.25, '2020-09-19', 54567963.00, 828116, 11102895.57, 0, 60.066, 28.985626283367555, '2019-09-19', 0, 2.310209, 1.686516),
(8, 5800000.00, 230, 135, 35, 62, 'Exitoso', 235.98, 0.46, 0.01, NULL, '2005-10-08', '2005-05-01', '2032-02-20', '2023-09-07 17:51:01', 6, 3, 1, 1.00, 221283.69, '2006-02-20', 591633.00, 381500, 340436.44, 0, 65, 26.368240930869266, '2005-02-20', 0, 2.777921, 0.438056),
(9, 5800000.00, 219, 146, 52, 62, 'Exitoso', 235.98, 0.46, 0.31, NULL, '2015-06-06', '2010-01-31', '2024-10-30', '2023-09-08 09:15:43', 7, 8, 1, 1.55, 527531.71, '2015-10-30', 39824246.00, 644350, 815048.06, 0, 64.724, 9.401779603011637, '2014-10-30', 0, 2.944284, 5.344285),
(10, 5800000.00, 6, 360, 28, 62, 'Exitoso', 216.48, 0.39, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-09-19', '2023-09-25 17:04:44', 1, 1, 1, 1.33, 775577.71, '2020-09-19', 4650692.00, 828116, 1196217.38, 0, 64.83585, 33.98494182067078, '2019-09-19', 0, 2.310209, 1.686516),
(11, 5800000.00, 230, 135, 35, 62, 'Exitoso', 235.98, 0.46, 0.01, NULL, '2005-10-08', '2005-05-01', '2032-02-20', '2023-09-25 17:08:36', 6, 8, 2, 1.00, 221283.69, '2006-02-20', 591633.00, 381500, 340436.44, 0, 65, 26.368240930869266, '2005-02-20', 0, 2.777921, 0.438056),
(12, 5800000.00, 219, 146, 52, 62, 'Exitoso', 194.28, 0.59, 0.16, NULL, '2015-06-06', '2010-01-31', '2024-10-30', '2023-09-25 17:11:24', 7, 4, 2, 1.55, 527531.71, '2015-10-30', 16656991.00, 644350, 815048.06, 0, 64.724, 19.567419575633128, '2014-10-30', 0, 2.944284, 5.344285),
(13, 5800000.00, 6, 360, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-09-19', '2023-09-25 17:13:04', 5, 8, 2, 1.33, 775577.71, '2020-09-19', 5074326.00, 828116, 1196217.38, 0, 64.83585, 33.98494182067078, '2019-09-19', 0, 2.310209, 1.686516),
(14, 5800000.00, 230, 135, 35, 57, 'Exitoso', 224.61, 0.37, 0.01, NULL, '2005-10-08', '2005-05-01', '2027-02-20', '2023-09-25 17:48:19', 1, 1, 1, 1.00, 251030.05, '2006-02-20', 700592.00, 381500, 386200.08, 0, 65, 24.476386036960985, '2005-02-20', 0, 2.777921, 0.438056),
(15, 5800000.00, 230, 135, 35, 57, 'Exitoso', 224.61, 0.37, 0.01, NULL, '2005-10-08', '2005-05-01', '2027-02-20', '2023-09-25 17:49:24', 1, 1, 1, 1.05, 263105.01, '2006-02-20', 733065.00, 381500, 404928.00, 0, 64.97575, 24.476386036960985, '2005-02-20', 0, 2.777921, 0.438056),
(16, 5800000.00, 6, 360, 28, 62, 'Exitoso', 216.48, 0.39, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-09-19', '2023-09-25 18:13:12', 1, 1, 1, 1.33, 775577.71, '2020-09-19', 4650692.00, 828116, 1196217.38, 0, 64.83585, 33.98494182067078, '2019-09-19', 0, 2.310209, 1.686516),
(17, 5800000.00, 6, 360, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-09-19', '2023-09-25 18:14:47', 1, 1, 1, 1.33, 775577.71, '2020-09-19', 5074326.00, 828116, 1196217.38, 0, 64.83585, 33.98494182067078, '2019-09-19', 0, 2.310209, 1.686516),
(18, 5800000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-09-25 19:23:22', 1, 1, 1, 1.09, 635745.39, '2020-02-25', 4281128.00, 828116, 978723.31, 0, 64.9566, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(19, 5800000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-09-25 19:27:17', 1, 1, 1, 8.45, 4664321.81, '2020-02-25', 30939049.00, 828116, 7612292.44, 0, 61.27355, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(20, 5800000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-09-25 19:27:22', 1, 1, 1, 9.66, 5278124.33, '2020-02-25', 35000707.00, 828116, 8699762.79, 0, 60.66975, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(21, 5800000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-09-25 19:27:41', 1, 1, 1, 10.63, 5759714.93, '2020-02-25', 38187492.00, 828116, 9569739.07, 0, 60.18675, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(22, 5800000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-09-25 19:29:14', 1, 1, 1, 10.70, 5795493.03, '2020-02-25', 38424243.00, 828116, 9634987.29, 0, 60.1505, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(23, 5800000.00, 219, 146, 56, 62, 'Exitoso', 194.28, 0.59, 0.29, NULL, '2019-06-06', '2010-01-31', '2024-10-30', '2023-09-25 19:57:51', 1, 1, 1, 10.87, 4673336.14, '2019-10-30', 266402134.00, 828116, 7780335.20, 0, 60.066, 15.567419575633128, '2018-10-30', 0, 2.75479, 9.344285),
(24, 5800000.00, 219, 146, 52, 57, 'Exitoso', 169.70, 0.53, 0.16, NULL, '2015-06-06', '2010-01-31', '2019-10-30', '2023-09-25 20:03:28', 1, 1, 1, 3.88, 1469209.67, '2015-10-30', 39687528.00, 644350, 2311530.07, 0, 63.56005, 19.567419575633128, '2014-10-30', 0, 2.944284, 5.344285),
(25, 5800000.00, 176, 189, 35, 62, 'Exitoso', 235.98, 0.46, 0.05, NULL, '2019-04-20', '2017-05-04', '2045-10-26', '2023-09-25 20:15:07', 1, 1, 1, 5.07, 2359846.69, '2019-10-26', 25276021.00, 828116, 3747924.13, 0, 62.9641, 26.518822724161534, '2018-10-26', 0, 2.777921, 1.960301),
(26, 11600000.00, 211, 154, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-26', '2023-10-06 16:06:11', 1, 1, 1, 10.87, 5878799.46, '2020-02-26', 39044875.00, 828116, 9787233.14, 0, 60.066, 33.42368240930869, '2019-02-26', 0, 2.310209, 1.686516),
(27, 11600000.00, 211, 154, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-26', '2023-10-06 16:19:10', 1, 1, 1, 25.00, 11931031.13, '2020-02-26', 79088722.00, 828116, 22510636.22, 0, 53.00175, 33.42368240930869, '2019-02-26', 0, 2.310209, 1.686516),
(28, 11600000.00, 211, 154, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-26', '2023-10-06 16:32:49', 1, 1, 1, 10.87, 5878799.46, '2020-02-26', 39044875.00, 828116, 9787233.14, 0, 60.066, 33.42368240930869, '2019-02-26', 0, 2.310209, 1.686516),
(29, 5878799.46, 211, 154, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-26', '2023-10-06 16:37:38', 1, 1, 1, 10.87, 5878799.46, '2020-02-26', 38971623.00, 828116, 9787233.14, 0, 60.066, 33.42368240930869, '2019-02-26', 0, 2.310209, 1.686516),
(30, 5800000.00, 176, 189, 35, 62, 'Exitoso', 235.98, 0.46, 0.05, NULL, '2019-04-20', '2017-05-04', '2045-10-26', '2023-10-06 16:40:12', 1, 1, 1, 5.07, 2359846.69, '2019-10-26', 25276021.00, 828116, 3747924.13, 0, 62.9641, 26.518822724161534, '2018-10-26', 0, 2.777921, 1.960301),
(31, 11600000.00, 212, 153, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-25', '2023-10-06 16:47:02', 1, 1, 1, 24.76, 11842674.44, '2020-02-25', 78513959.00, 828116, 22293142.15, 0, 53.1225, 33.42094455852156, '2019-02-25', 0, 2.310209, 1.686516),
(32, 5878799.46, 211, 154, 28, 62, 'Exitoso', 235.98, 0.46, 0.03, NULL, '2019-09-25', '2018-01-17', '2053-02-26', '2023-10-07 09:40:32', 7, 8, 1, 10.87, 5878799.46, '2020-02-26', 38971623.00, 828116, 9787233.14, 0, 60.066, 33.42368240930869, '2019-02-26', 0, 2.310209, 1.686516);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `edad_referencia`
--

CREATE TABLE `edad_referencia` (
  `id_edad` int(11) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `edad_referencia`
--

INSERT INTO `edad_referencia` (`id_edad`, `edad`, `genero`) VALUES
(1, 57, 'Femenino'),
(2, 62, 'Masculino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleadores`
--

CREATE TABLE `empleadores` (
  `id_empleador` int(11) NOT NULL,
  `correo_empleador` varchar(255) DEFAULT NULL,
  `identificador_empleador` varchar(255) DEFAULT NULL,
  `nombre_empleador` varchar(255) DEFAULT NULL,
  `telefono_empleador` varchar(255) DEFAULT NULL,
  `tipo_documento_empleador` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleadores`
--

INSERT INTO `empleadores` (`id_empleador`, `correo_empleador`, `identificador_empleador`, `nombre_empleador`, `telefono_empleador`, `tipo_documento_empleador`) VALUES
(1, 'empleador1@gmail.com', '90005866852', 'Alkosto SA', '7589665', 'NIT'),
(2, 'empleador2@gmail.com', '905484782', 'Alqueria', '4552288', 'NIT'),
(3, 'empleado31@gmail.com', '80074621515', 'Permoda', '68521552', 'NIT'),
(4, 'agenciacenit@gmail.com', '9012470941', 'Agencia Cenit SAS', '3028668722', 'NIT'),
(5, 'House-Solutions@gmail.com', '123456', 'House Solutions', '3147195555', 'NIT'),
(6, 'inno@gmail.com', '123456789', 'Inno Deportes', '4565555', 'NIT'),
(7, 'Visual_Monitores@gmail.com', '9699999', 'Visual Monitores', '55555', 'NIT'),
(8, 'bona@gmail.com', '9011395670', 'Bona Nit Chic S A S', '3004860732', 'NIT'),
(9, 'instaClothes@gmail.com', '9011395852', 'InstaClothes', '3117858858', 'NIT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `apellidos_empleado` varchar(255) DEFAULT NULL,
  `correo_empleado` varchar(255) DEFAULT NULL,
  `direccion_empleado` varchar(255) DEFAULT NULL,
  `fecha_nacimiento_empleado` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificador_empleado` varchar(255) DEFAULT NULL,
  `nombres_empleado` varchar(255) DEFAULT NULL,
  `telefono_empleado` varchar(255) DEFAULT NULL,
  `tipo_documento_empleado` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `apellidos_empleado`, `correo_empleado`, `direccion_empleado`, `fecha_nacimiento_empleado`, `genero`, `identificador_empleado`, `nombres_empleado`, `telefono_empleado`, `tipo_documento_empleado`) VALUES
(1, 'Vasquez', 'vasquez_sofia@gmail.com', 'KR 20 # 56 - 89 ', '1975-02-15', 'Femenino', '1030598618', 'Sofia', '3186009265', 'CC'),
(2, 'Benitez', 'maria_benitez@hotmail.com', 'CALLE 78 # 54 - 69', '1985-05-06', 'Femenino', '1033562415', 'Maria Eva', '3193002939', 'CC'),
(3, 'Borja Belmonte', 'fbbelmonte1983@yahoo.es', 'AV Circunvalar # 78 - 96', '1983-10-26', 'Masculino', '65784596', 'Francisco', '3156988935', 'CC'),
(4, 'Benavides', 'caridad569@gmail.com', 'Calle 59 # 85 - 96 Sur', '1991-09-19', 'Femenino', '123456789', 'Caridad', '3112222223', 'CC'),
(5, 'Santamaria', 'santamariab@gmail.com', 'Calle 45 # 78 - 5', '1991-09-19', 'Masculino', '98745631', 'Basilio', '7895632', 'CC'),
(6, 'Pallares EJ4', 'srcaballero144@gmail.com', 'KR 77 N 55 15 SUR, , 110861', '1970-02-20', 'Masculino', '147852369', 'Pepito', '3186009265', 'CC'),
(7, 'cinco', 'prueba@gmail.com', 'kr 20', '1991-02-26', 'Masculino', '123456987', 'Ejemplo', '315625889', 'CC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac1`
--

CREATE TABLE `fac1` (
  `id_fac1` int(11) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `hombres` double DEFAULT NULL,
  `mujeres` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fac1`
--

INSERT INTO `fac1` (`id_fac1`, `edad`, `hombres`, `mujeres`) VALUES
(1, 55, 258.712212, 243.005182),
(2, 56, 255.775386, 239.546338),
(3, 57, 252.73826, 235.977078),
(4, 58, 249.598775, 232.296362),
(5, 59, 246.355, 228.506137),
(6, 60, 243.005182, 224.60602),
(7, 61, 239.546338, 220.596052),
(8, 62, 235.977078, 216.47656),
(9, 63, 232.296362, 212.248425),
(10, 64, 228.506137, 207.912956),
(11, 65, 224.60602, 203.471943),
(12, 66, 220.596052, 198.927674),
(13, 67, 216.47656, 194.283137),
(14, 68, 212.248425, 189.541818),
(15, 69, 207.912956, 184.707913),
(16, 70, 203.471943, 179.786208),
(17, 71, 198.927674, 174.782204),
(18, 72, 194.283137, 169.702078),
(19, 73, 189.541818, 164.552725),
(20, 74, 184.707913, 159.341662),
(21, 75, 179.786208, 154.077066),
(22, 76, 174.782204, 148.767735),
(23, 77, 169.702078, 143.423124),
(24, 78, 164.552725, 138.053206),
(25, 79, 159.341662, 132.668444),
(26, 80, 154.077066, 127.279561),
(27, 81, 148.767735, 121.897577),
(28, 82, 143.423124, 116.533716),
(29, 83, 138.053206, 111.199165),
(30, 84, 132.668444, 105.904739),
(31, 85, 127.279561, 100.661169),
(32, 86, 121.897577, 95.47833),
(33, 87, 116.533716, 90.365266),
(34, 88, 111.199165, 85.329825),
(35, 89, 105.904739, 80.378652),
(36, 90, 100.661169, 75.516659);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac2`
--

CREATE TABLE `fac2` (
  `id_fac2` int(11) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `hombres` double DEFAULT NULL,
  `mujeres` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `fac2`
--

INSERT INTO `fac2` (`id_fac2`, `edad`, `hombres`, `mujeres`) VALUES
(1, 55, 0.369543, 0.311687),
(2, 56, 0.381199, 0.322235),
(3, 57, 0.393132, 0.333081),
(4, 58, 0.405334, 0.344225),
(5, 59, 0.417797, 0.355667),
(6, 60, 0.430511, 0.367403),
(7, 61, 0.443465, 0.379431),
(8, 62, 0.456646, 0.391747),
(9, 63, 0.470038, 0.404345),
(10, 64, 0.483532, 0.417217),
(11, 65, 0.497111, 0.430356),
(12, 66, 0.510762, 0.443751),
(13, 67, 0.524466, 0.45739),
(14, 68, 0.538207, 0.471261),
(15, 69, 0.551966, 0.485348),
(16, 70, 0.565725, 0.499635),
(17, 71, 0.579465, 0.514104),
(18, 72, 0.593165, 0.528734),
(19, 73, 0.606808, 0.543503),
(20, 74, 0.620372, 0.558388),
(21, 75, 0.633837, 0.573365),
(22, 76, 0.647184, 0.588406),
(23, 77, 0.660392, 0.603484),
(24, 78, 0.673442, 0.618571),
(25, 79, 0.686313, 0.633634),
(26, 80, 0.698988, 0.648645),
(27, 81, 0.711448, 0.663572),
(28, 82, 0.723675, 0.678385),
(29, 83, 0.735655, 0.693051),
(30, 84, 0.74737, 0.707542),
(31, 85, 0.758807, 0.721827),
(32, 86, 0.769955, 0.73588),
(33, 87, 0.780801, 0.749677),
(34, 88, 0.791336, 0.763196),
(35, 89, 0.801555, 0.776422),
(36, 90, 0.811453, 0.789343);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salario_medio_nacional`
--

CREATE TABLE `salario_medio_nacional` (
  `id_smn` int(11) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `salario_medio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salario_medio_nacional`
--

INSERT INTO `salario_medio_nacional` (`id_smn`, `edad`, `salario_medio`) VALUES
(1, 12, 1),
(2, 13, 1.006649),
(3, 14, 1.135599),
(4, 15, 1.206678),
(5, 16, 1.279752),
(6, 17, 1.354687),
(7, 18, 1.431251),
(8, 19, 1.509273),
(9, 20, 1.588504),
(10, 21, 1.668693),
(11, 22, 1.749612),
(12, 23, 1.830933),
(13, 24, 1.912388),
(14, 25, 1.993652),
(15, 26, 2.074416),
(16, 27, 2.154318),
(17, 28, 2.233031),
(18, 29, 2.310209),
(19, 30, 2.385489),
(20, 31, 2.458524),
(21, 32, 2.528971),
(22, 33, 2.596463),
(23, 34, 2.660676),
(24, 35, 2.721264),
(25, 36, 2.777921),
(26, 37, 2.830357),
(27, 38, 2.878287),
(28, 39, 2.941441),
(29, 40, 2.95957),
(30, 41, 2.992482),
(31, 42, 3.020004),
(32, 43, 3.041946),
(33, 44, 3.05821),
(34, 45, 3.068682),
(35, 46, 3.073323),
(36, 47, 3.072096),
(37, 48, 3.065019),
(38, 49, 3.052111),
(39, 50, 3.033468),
(40, 51, 3.009187),
(41, 52, 2.979401),
(42, 53, 2.944284),
(43, 54, 2.904026),
(44, 55, 2.858858),
(45, 56, 2.80903),
(46, 57, 2.75479),
(47, 58, 2.696446),
(48, 59, 2.634304),
(49, 60, 2.568691),
(50, 61, 2.499933),
(51, 62, 2.428355),
(52, 63, 2.354341),
(53, 64, 2.278237),
(54, 65, 2.200368),
(55, 66, 2.121119),
(56, 67, 2.040814),
(57, 68, 1.9598),
(58, 69, 1.878421),
(59, 70, 1.796985),
(60, 71, 1.715798);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salario_minimo`
--

CREATE TABLE `salario_minimo` (
  `id_salario` int(11) NOT NULL,
  `ano` int(11) DEFAULT NULL,
  `salario` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `salario_minimo`
--

INSERT INTO `salario_minimo` (`id_salario`, `ano`, `salario`) VALUES
(1, 2000, 260100),
(2, 2001, 286000),
(3, 2002, 309000),
(4, 2003, 332000),
(5, 2004, 358000),
(6, 2005, 381500),
(7, 2006, 408000),
(8, 2007, 433700),
(9, 2008, 461500),
(10, 2009, 496900),
(11, 2010, 515000),
(12, 2011, 535600),
(13, 2012, 566700),
(14, 2013, 589500),
(15, 2014, 616000),
(16, 2015, 644350),
(17, 2016, 689455),
(18, 2017, 737717),
(19, 2018, 781242),
(20, 2019, 828116),
(21, 2020, 877803),
(22, 2021, 908526),
(23, 2022, 1000000),
(25, 1999, 236460),
(26, 1998, 203826),
(27, 1998, 203826),
(28, 1998, 203826),
(29, 1997, 172005),
(30, 1996, 142125),
(31, 1995, 118934),
(32, 1994, 98700),
(33, 1993, 81510),
(34, 1992, 65190),
(35, 1991, 51716),
(36, 1990, 41025),
(37, 1989, 32560),
(38, 1988, 25637),
(39, 1987, 20510),
(40, 1986, 16811),
(41, 1985, 13558),
(42, 1984, 11298),
(43, 2023, 1160000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semanas_minimas`
--

CREATE TABLE `semanas_minimas` (
  `id_sem_min` int(11) NOT NULL,
  `año` int(11) DEFAULT NULL,
  `sem_min` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `semanas_minimas`
--

INSERT INTO `semanas_minimas` (`id_sem_min`, `año`, `sem_min`) VALUES
(1, 2000, 1000),
(2, 2001, 1000),
(3, 2002, 1000),
(4, 2003, 1000),
(5, 2004, 1000),
(6, 2005, 1050),
(7, 2006, 1075),
(8, 2007, 1100),
(9, 2008, 1125),
(10, 2009, 1150),
(11, 2010, 1175),
(12, 2011, 1200),
(13, 2012, 1225),
(14, 2013, 1250),
(15, 2014, 1275),
(16, 2015, 1300),
(17, 2016, 1300),
(18, 2017, 1300),
(19, 2018, 1300),
(20, 2019, 1300),
(21, 2020, 1300),
(22, 2021, 1300),
(23, 2022, 1300),
(24, 2023, 1300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tipo_usuario` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `estado`, `nombre`, `password`, `tipo_usuario`, `username`) VALUES
(1, 'activo', 'Administrador', '$2a$10$etipZg1Ht.fVE6htvbsM4eF9JHvgg6.an0dH1iYjeiArGA5XXzTga', 'administrador', 'admin'),
(2, 'activo', 'Tatiana Vallejo', '$2a$10$//nnwRG3ZVymRN66Db.ZYe0WKFIDTAM7WvXgcglz8WM4Zw6XVxyai', 'asesor', 'itvallejos'),
(3, 'inactivo', 'Yuselfy Vanegas', '$2a$10$Ah2BE6Vp/VzXbWFzOktFG.Mm7Y5Vi/taxzD8QFYkv6pLN75w1Q14i', 'asesor', 'yvanegas'),
(5, 'activo', 'Carolina Herrera', '$2a$10$OawTl9H3Lsc16DS0c21kHujiw9FfUCveSdIZdjrBpGBG3CPdb/nR2', 'asesor', 'jherrera');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calculo_actuarial`
--
ALTER TABLE `calculo_actuarial`
  ADD PRIMARY KEY (`id_calculo`);

--
-- Indices de la tabla `edad_referencia`
--
ALTER TABLE `edad_referencia`
  ADD PRIMARY KEY (`id_edad`);

--
-- Indices de la tabla `empleadores`
--
ALTER TABLE `empleadores`
  ADD PRIMARY KEY (`id_empleador`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `fac1`
--
ALTER TABLE `fac1`
  ADD PRIMARY KEY (`id_fac1`);

--
-- Indices de la tabla `fac2`
--
ALTER TABLE `fac2`
  ADD PRIMARY KEY (`id_fac2`);

--
-- Indices de la tabla `salario_medio_nacional`
--
ALTER TABLE `salario_medio_nacional`
  ADD PRIMARY KEY (`id_smn`);

--
-- Indices de la tabla `salario_minimo`
--
ALTER TABLE `salario_minimo`
  ADD PRIMARY KEY (`id_salario`);

--
-- Indices de la tabla `semanas_minimas`
--
ALTER TABLE `semanas_minimas`
  ADD PRIMARY KEY (`id_sem_min`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calculo_actuarial`
--
ALTER TABLE `calculo_actuarial`
  MODIFY `id_calculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `edad_referencia`
--
ALTER TABLE `edad_referencia`
  MODIFY `id_edad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empleadores`
--
ALTER TABLE `empleadores`
  MODIFY `id_empleador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `fac1`
--
ALTER TABLE `fac1`
  MODIFY `id_fac1` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `fac2`
--
ALTER TABLE `fac2`
  MODIFY `id_fac2` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT de la tabla `salario_medio_nacional`
--
ALTER TABLE `salario_medio_nacional`
  MODIFY `id_smn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `salario_minimo`
--
ALTER TABLE `salario_minimo`
  MODIFY `id_salario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `semanas_minimas`
--
ALTER TABLE `semanas_minimas`
  MODIFY `id_sem_min` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
