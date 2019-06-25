
DROP TABLE IF EXISTS Member;
CREATE TABLE `Member` (
	`MEMBER_ID` INT(11) NOT NULL AUTO_INCREMENT,
	`ID` VARCHAR(50) NOT NULL,
	`TYPE` INT(11) NOT NULL DEFAULT '0',
	`PASSWORD` VARCHAR(50) NOT NULL,
	`CREATE_TIME` INT(10) NOT NULL,
	`UPDATE_TIME` INT(10) NOT NULL,
	PRIMARY KEY (`MEMBER_ID`),
	UNIQUE INDEX `ID` (`ID`)
)ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS MemberInfo;
CREATE TABLE `MemberInfo` (
	`MEMBER_ID` INT(11) NOT NULL,
	`NAME` VARCHAR(50) NOT NULL,
	`GENDER` INT(11) NOT NULL DEFAULT '0',
	`TEL` VARCHAR(50) NOT NULL,
	`ADDR` VARCHAR(50) NOT NULL,
	`IMAGE_URL` varchar(255) DEFAULT NULL,
	`CREATE_TIME` INT(10) NOT NULL,
	`UPDATE_TIME` INT(10) NOT NULL,
	PRIMARY KEY (`MEMBER_ID`)
)ENGINE=InnoDB CHARSET=utf8;

DROP TABLE IF EXISTS CrocMemberInfo;
CREATE TABLE `CrocMemberInfo` (
  `MEMBER_ID` int(11) NOT NULL,
  `LEVEL` int(11) NOT NULL DEFAULT '0',
  `NAME` varchar(50) NOT NULL,
  `GENDER` int(11) NOT NULL DEFAULT '0',
  `UNIV` varchar(50) NOT NULL DEFAULT '0',
  `MAJOR` varchar(50) NOT NULL DEFAULT '0',
  `TEL` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IMAGE_URL` varchar(255) DEFAULT NULL,
  `CREATE_TIME` int(10) NOT NULL,
  `UPDATE_TIME` int(10) NOT NULL,
  PRIMARY KEY (`MEMBER_ID`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS CrocAvailableService;
CREATE TABLE `CrocAvailableService` (
  `MEMBER_ID` int(11) NOT NULL,
  `SERVICE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS CrocAvailableTime;
CREATE TABLE `CrocAvailableTime` (
  `TIME_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int(11) NOT NULL,
  `DAY` int(11) NOT NULL DEFAULT '0',
  `START_TIME` int(11) NOT NULL,
  `END_TIME` int(11) NOT NULL,
  PRIMARY KEY (`TIME_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS CrocAvailableRegion;
CREATE TABLE `CrocAvailableRegion` (
	`MEMBER_ID` INT(11) NOT NULL,
	`REGION_ID` INT(11) NOT NULL,
)ENGINE=InnoDB;

DROP TABLE IF EXISTS BabyInfo;
CREATE TABLE `BabyInfo` (
	`BABY_ID` int(11) NOT NULL AUTO_INCREMENT,
	`MEMBER_ID` int(11) NOT NULL,
	`NAME` varchar(50) NOT NULL,
	`AGE` int(11) NOT NULL,
	`GENDER` int(11) NOT NULL DEFAULT '0',
	`IMAGE_URL` varchar(255) DEFAULT NULL,
	`CREATE_TIME` int(10) NOT NULL,
	`UPDATE_TIME` int(10) NOT NULL,
	PRIMARY KEY (`BABY_ID`),
)ENGINE=InnoDB;

DROP TABLE IF EXISTS SNSInfo;
CREATE TABLE `SNSInfo` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int(11) NOT NULL,
  `SNS_ID` varchar(50) NOT NULL,
  `SNS_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS GCMInfo;
CREATE TABLE `GCMInfo` (
  `IDX` int(11) NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int(11) NOT NULL,
  `GCM_ID` varchar(255) NOT NULL,
  `DEVICE_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`IDX`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;