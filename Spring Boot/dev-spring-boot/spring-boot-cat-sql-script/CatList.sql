CREATE DATABASE  IF NOT EXISTS `cat_directory`;
USE `cat_directory`;

--
-- Table structure for table `cat`
--

DROP TABLE IF EXISTS `cat`;

CREATE TABLE `cat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) DEFAULT NULL,
  `cat_race` varchar(45) DEFAULT NULL,
  `cat_gender` varchar(45) DEFAULT NULL,
  `cat_age` int(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `cat` VALUES 
	(1,'Xena','Bombai','Female',3),
	(2,'300','Siamese','Female',9),
	(3,'Double','Norwegian Forest','Female',2),
	(4,'Jackal','Siamese','Male',8),
	(5,'Mephisto','Persian','Male',5);

