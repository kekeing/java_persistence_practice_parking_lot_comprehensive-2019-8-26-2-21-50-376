DROP TABLE IF EXISTS `parkingboy`;
CREATE TABLE `parkingboy` (
  `parkingboyId` int(11) NOT NULL,
  `parkingboyName` varchar(50) DEFAULT NULL,
  `parkingboyAge` int(3) DEFAULT NULL,
  PRIMARY KEY (`parkingboyId`)
) ;
INSERT INTO `parkingboy` VALUES ('1', 'xiexinfang', '18');
INSERT INTO `parkingboy` VALUES ('2', 'caoyupeng', '18');

DROP TABLE IF EXISTS `parkinglot`;
CREATE TABLE `parkinglot` (
  `parkinglotId` int(11) NOT NULL,
  `parkinglotCapasity` int(11) DEFAULT NULL,
  `parkinglotAvailablePositionCount` int(11) DEFAULT NULL,
  `parkingboyId` int(11) DEFAULT NULL,
  PRIMARY KEY (`parkinglotId`),
  FOREIGN KEY(parkingboyId) REFERENCES parkingboy(parkingboyId)
  );

INSERT INTO `parkinglot` VALUES ('1', '50', '50', '1');
INSERT INTO `parkinglot` VALUES ('2', '80', '80', '2');