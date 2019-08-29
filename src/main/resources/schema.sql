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
  `parkingboyId` int(11) NOT NULL,
  `parkingboyName` varchar(50) DEFAULT NULL,
  `parkingboyAge` int(3) DEFAULT NULL,
  PRIMARY KEY (`parkingboyId`)
) ;

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
  `parkinglotId` int(11) NOT NULL,
  `parkinglotCapasity` int(11) DEFAULT NULL,
  `parkinglotAvailablePositionCount` int(11) DEFAULT NULL,
  `parkingboyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`parkinglotId`),
  FOREIGN KEY(parkingboyId) REFERENCES parkingboy(parkingboyId)
--   KEY `parkingboy_id` (`parkingboy_id`),
--   CONSTRAINT `parkingboy_id` FOREIGN KEY (`parkingboy_id`) REFERENCES `parkingboy` (`parkingboy_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;

-- ----------------------------
-- Records of parkinglot
-- ----------------------------
INSERT INTO `parkinglot` VALUES ('1', '50', '50', '1');
INSERT INTO `parkinglot` VALUES ('2', '80', '80', '2');
