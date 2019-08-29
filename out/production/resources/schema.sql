/*
Navicat MySQL Data Transfer

Source Server         : jingxi_mall
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : parkingboy

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-08-29 19:53:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `parkingboy`
-- ----------------------------
DROP TABLE IF EXISTS `parkingboy`;
CREATE TABLE `parkingboy` (
  `parkingboy_id` int(11) NOT NULL,
  `parkingboy_name` varchar(50) DEFAULT NULL,
  `parkingboy_age` int(3) DEFAULT NULL,
  PRIMARY KEY (`parkingboy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkingboy
-- ----------------------------
INSERT INTO `parkingboy` VALUES ('1', 'xiexinfang', '18');
INSERT INTO `parkingboy` VALUES ('2', 'caoyupeng', '18');

-- ----------------------------
-- Table structure for `parkinglot`
-- ----------------------------
DROP TABLE IF EXISTS `parkinglot`;
CREATE TABLE `parkinglot` (
  `parkinglot_id` int(11) NOT NULL,
  `parkinglot_capasity` int(11) DEFAULT NULL,
  `parkinglot_available_position_count` int(11) DEFAULT NULL,
  `parkingboy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`parkinglot_id`),
  FOREIGN KEY(parkingboy_id) REFERENCES parkingboy(parkingboy_id)
--   KEY `parkingboy_id` (`parkingboy_id`),
--   CONSTRAINT `parkingboy_id` FOREIGN KEY (`parkingboy_id`) REFERENCES `parkingboy` (`parkingboy_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkinglot
-- ----------------------------
INSERT INTO `parkinglot` VALUES ('1', '50', '50', '1');
INSERT INTO `parkinglot` VALUES ('2', '80', '80', '2');