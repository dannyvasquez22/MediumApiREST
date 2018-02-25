/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 10.1.25-MariaDB : Database - restspring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`restspring` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;

USE `restspring`;

/*Table structure for table `nota` */

DROP TABLE IF EXISTS `nota`;

CREATE TABLE `nota` (
  `id_nota` bigint(20) NOT NULL AUTO_INCREMENT,
  `contenido` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `titulo` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_nota`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

/*Data for the table `nota` */

insert  into `nota`(`id_nota`,`contenido`,`nombre`,`titulo`) values 
(1,'Este es la descripcion de mi primera nota','Danny','MiPrimeraNota'),
(3,'Este es la descripcion de segunda nota','Fernan','SegundaNota'),
(4,'Este es la descripcion de tercera nota','Deadpool','TerceraNota'),
(5,'Este es la descripcion de cuarta nota','Arnuldo','CuartaNota'),
(6,'Este es la descripcion de Ejemplo1','NotaEjemplo1','Ejemplo1'),
(7,'Este es la descripcion de Ejemplo2','NotaEjemplo2','Ejemplo2'),
(8,'Este es la descripcion de Ejemplo3','NotaEjemplo3','Ejemplo3'),
(9,'Este es la descripcion de Ejemplo4','NotaEjemplo4','Ejemplo4'),
(10,'Este es la descripcion de Ejemplo5','NotaEjemplo5','Ejemplo5'),
(11,'Este es la descripcion de Ejemplo6','NotaEjemplo6','Ejemplo6'),
(12,'Este es la descripcion de Ejemplo7','NotaEjemplo7','Ejemplo7'),
(13,'Este es la descripcion de Ejemplo8','NotaEjemplo8','Ejemplo8'),
(14,'Este es la descripcion de Ejemplo9','NotaEjemplo9','Ejemplo9'),
(15,'Este es la descripcion de Ejemplo10','NotaEjemplo10','Ejemplo10'),
(16,'Este es la descripcion de Ejemplo11','NotaEjemplo11','Ejemplo11'),
(17,'Este es la descripcion de Ejemplo12','NotaEjemplo12','Ejemplo12'),
(18,'Este es la descripcion de Ejemplo13','NotaEjemplo13','Ejemplo13'),
(19,'Este es la descripcion de Ejemplo14','NotaEjemplo14','Ejemplo14'),
(20,'Este es la descripcion de Ejemplo15','NotaEjemplo15','Ejemplo15'),
(21,'Este es la descripcion de Ejemplo16','NotaEjemplo16','Ejemplo16'),
(22,'Este es la descripcion de Ejemplo17','NotaEjemplo17','Ejemplo17'),
(23,'Este es la descripcion de Ejemplo18','NotaEjemplo18','Ejemplo18'),
(24,'Este es la descripcion de Ejemplo19','NotaEjemplo19','Ejemplo19'),
(25,'Este es la descripcion de Ejemplo20','NotaEjemplo20','Ejemplo20');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) DEFAULT NULL,
  `contraseña` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `rol` tinyint(4) DEFAULT NULL,
  `usuario` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i02kr8ui5pqddyd7pkm3v4jbt` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`activo`,`contraseña`,`rol`,`usuario`) values 
(1,'','12345',1,'danny');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
