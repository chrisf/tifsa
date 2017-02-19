CREATE DATABASE IF NOT EXISTS tifsa;

USE tifsa;

-- Address related tables (country, state, etc)
CREATE TABLE `AddCountry` (
  `AddCountryID` int(11) NOT NULL AUTO_INCREMENT,
  `AddCountryName` varchar(255) NOT NULL,
  PRIMARY KEY (`AddCountryID`),
  UNIQUE KEY `AddCountry_AddCountryID_uindex` (`AddCountryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lookup table for countries in addresses';

CREATE TABLE `AddState` (
  `AddStateID` int(11) NOT NULL AUTO_INCREMENT,
  `AddCountryID` int(11) NOT NULL,
  `AddStateName` varchar(255) NOT NULL,
  `AddStateAbbreviation` varchar(2) NOT NULL,
  PRIMARY KEY (`AddStateID`),
  UNIQUE KEY `AddState_AddStateID_uindex` (`AddStateID`),
  KEY `AddState_AddCountry_AddCountryID_fk` (`AddCountryID`),
  CONSTRAINT `AddState_AddCountry_AddCountryID_fk` FOREIGN KEY (`AddCountryID`) REFERENCES `AddCountry` (`AddCountryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lookup table for states in addresses';

-- Customer related tables
CREATE TABLE `CustomerType` (
  `CustTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `CustTypeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CustTypeID`),
  UNIQUE KEY `CustomerType_CustTypeID_uindex` (`CustTypeID`),
  UNIQUE KEY `CustomerType_CustTypeName_uindex` (`CustTypeName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lookup table that identifies what type of customer a Customer is';

CREATE TABLE `Customer` (
  `CustID` int(11) NOT NULL AUTO_INCREMENT,
  `CustBusName` varchar(255) DEFAULT NULL,
  `CustFirst` varchar(255) DEFAULT NULL,
  `CustMidInt` varchar(255) DEFAULT NULL,
  `CustLast` varchar(255) DEFAULT NULL,
  `CustBillFirst` varchar(255) DEFAULT NULL,
  `CustBillMidInt` varchar(255) DEFAULT NULL,
  `CustBillLast` varchar(255) DEFAULT NULL,
  `CustAddedOn` datetime DEFAULT NULL,
  `CustAddStreet` varchar(255) DEFAULT NULL,
  `CustAddStreet2` varchar(255) DEFAULT NULL,
  `CustAddCity` varchar(255) DEFAULT NULL,
  `AddStateID` int(11) DEFAULT NULL,
  `CustAddZip` varchar(255) DEFAULT NULL,
  `CustTypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CustID`),
  UNIQUE KEY `Customer_CustID_uindex` (`CustID`),
  KEY `Customer_AddState_AddStateID_fk` (`AddStateID`),
  CONSTRAINT `Customer_AddState_AddStateID_fk` FOREIGN KEY (`AddStateID`) REFERENCES `AddState` (`AddStateID`),
  CONSTRAINT `Customer_CustomerType_CustTypeID_fk`  FOREIGN KEY  (`CustTypeID`) REFERENCES  `CustomerType` (`CustTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Holds customer information';