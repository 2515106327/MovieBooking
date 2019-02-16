/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.60 : Database - moviedata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`moviedata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `moviedata`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(45) NOT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `a_id` (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `area` */

insert  into `area`(`a_id`,`a_name`) values (2,'郫都区'),(3,'龙泉驿区'),(4,'温江区'),(5,'新都区'),(6,'华阳区'),(7,'武侯区'),(8,'金牛区');

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `b_date` datetime DEFAULT NULL,
  `b_paym` double DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `FK_Relationship_4` (`s_id`),
  KEY `FK_Relationship_5` (`u_id`),
  KEY `FK_Relationship_8` (`t_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`s_id`) REFERENCES `seat` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_8` FOREIGN KEY (`t_id`) REFERENCES `timing` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `booking` */

/*Table structure for table `cinema` */

DROP TABLE IF EXISTS `cinema`;

CREATE TABLE `cinema` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_id` int(11) DEFAULT NULL,
  `c_adr` varchar(20) NOT NULL,
  `c_name` varchar(20) NOT NULL,
  `c_num` int(11) NOT NULL,
  `c_tel` char(11) NOT NULL,
  `mov_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `FK_Relationship_3` (`a_id`),
  KEY `mov_id` (`mov_id`),
  CONSTRAINT `cinema_ibfk_1` FOREIGN KEY (`mov_id`) REFERENCES `movie_user` (`mov_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`a_id`) REFERENCES `area` (`a_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cinema` */

insert  into `cinema`(`c_id`,`a_id`,`c_adr`,`c_name`,`c_num`,`c_tel`,`mov_id`) values (3,2,'cdtu','天河影院',3,'12345678',1),(4,2,'阿贾克斯发的表空间','太平洋影院',2,'13540409972',2);

/*Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(20) NOT NULL,
  `f_director` varchar(10) NOT NULL,
  `f_play` varchar(50) NOT NULL,
  `f_intro` varchar(1000) NOT NULL,
  `f_language` varchar(10) NOT NULL,
  `f_long` int(11) NOT NULL,
  `f_date` date NOT NULL,
  `hot` int(11) DEFAULT NULL,
  `f_type` varchar(20) NOT NULL,
  `f_avatar` varchar(50) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `film_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `cinema` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `film` */

insert  into `film`(`f_id`,`f_name`,`f_director`,`f_play`,`f_intro`,`f_language`,`f_long`,`f_date`,`hot`,`f_type`,`f_avatar`,`c_id`) values (10,'我爱大海','黎睿','黎睿','lrui','黎睿与',120,'2017-04-05',0,'爱情片','images/film/8e006ab4268d470a98277de4cbdc871d',3),(11,'ajshu ','阿斯都没','是大号','仨都改u的辉煌的辐射防护 ','中问 ',110,'2018-06-05',0,'动作片','images/film/2cbf1dffdcf74e5781d26e4ae945e438',3),(12,'钢铁侠','黎睿','黎睿','你去死','西班牙语',12,'2017-04-05',0,'爱情片','images/avatar/38ae437338ac41c69dded2b39ffc4b8a',4),(13,'侏罗纪公园','黎睿','黎睿','黎睿','葡萄牙语',1,'2017-04-05',0,'美食','images/film/a3380b21ecb84bcda61e31aeca781ab3',4);

/*Table structure for table `movie_hall` */

DROP TABLE IF EXISTS `movie_hall`;

CREATE TABLE `movie_hall` (
  `mh_id` char(32) NOT NULL,
  `c_id` int(11) DEFAULT NULL,
  `seat_number` int(11) DEFAULT NULL,
  `mh_name` varchar(6) NOT NULL,
  PRIMARY KEY (`mh_id`),
  KEY `FK_Relationship_1` (`c_id`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`c_id`) REFERENCES `cinema` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movie_hall` */

insert  into `movie_hall`(`mh_id`,`c_id`,`seat_number`,`mh_name`) values ('9341d270356549b0878851e3cc72f584',4,0,'2号'),('a575f53efcfd4c58989139f3993e50e8',3,0,'3号'),('a81726231ae94ec6b6453da17df1fd97',3,0,'2号'),('dad962cee18b4a6bacac475b638aa1d4',3,0,'1号'),('ef7f9cd2849d402693cd0d09d0018e3a',4,0,'1号');

/*Table structure for table `movie_user` */

DROP TABLE IF EXISTS `movie_user`;

CREATE TABLE `movie_user` (
  `mov_id` int(11) NOT NULL AUTO_INCREMENT,
  `mov_name` varchar(20) DEFAULT NULL,
  `mov_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `movie_user` */

insert  into `movie_user`(`mov_id`,`mov_name`,`mov_password`) values (1,'lr','123'),(2,'文成','123456');

/*Table structure for table `seat` */

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `mh_id` char(32) DEFAULT NULL,
  `s_xid` char(2) DEFAULT NULL,
  `s_yid` char(2) DEFAULT NULL,
  `s_op` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`s_id`),
  KEY `FK_Relationship_2` (`mh_id`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`mh_id`) REFERENCES `movie_hall` (`mh_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `seat` */

insert  into `seat`(`s_id`,`mh_id`,`s_xid`,`s_yid`,`s_op`) values (1,'9341d270356549b0878851e3cc72f584','00','00',1),(2,'9341d270356549b0878851e3cc72f584','00','01',1);

/*Table structure for table `system_user` */

DROP TABLE IF EXISTS `system_user`;

CREATE TABLE `system_user` (
  `sys_id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_username` varchar(20) DEFAULT NULL,
  `sys_password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sys_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `system_user` */

insert  into `system_user`(`sys_id`,`sys_username`,`sys_password`) values (1,'test','123');

/*Table structure for table `timing` */

DROP TABLE IF EXISTS `timing`;

CREATE TABLE `timing` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_id` int(11) DEFAULT NULL,
  `mh_id` char(32) DEFAULT NULL,
  `t_start` datetime NOT NULL,
  `t_end` datetime NOT NULL,
  `t_price` double NOT NULL,
  `c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  KEY `FK_Relationship_6` (`mh_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`mh_id`) REFERENCES `movie_hall` (`mh_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `timing_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `cinema` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `timing` */

insert  into `timing`(`t_id`,`f_id`,`mh_id`,`t_start`,`t_end`,`t_price`,`c_id`) values (5,10,'dad962cee18b4a6bacac475b638aa1d4','2019-01-01 19:23:00','2019-01-01 19:24:00',12000,3),(6,11,'a81726231ae94ec6b6453da17df1fd97','2019-01-01 19:23:00','2019-01-01 19:24:00',1,3),(7,12,'9341d270356549b0878851e3cc72f584','2019-01-01 19:23:00','2019-01-01 19:24:00',123,4),(8,13,'9341d270356549b0878851e3cc72f584','2019-01-01 19:23:00','2019-01-01 19:24:00',23,4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(45) DEFAULT NULL,
  `u_password` varchar(45) DEFAULT NULL,
  `u_sex` char(2) DEFAULT NULL,
  `u_avatar` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_username`,`u_password`,`u_sex`,`u_avatar`) values (1,'opr','123','on',NULL),(2,'we','123','on',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
