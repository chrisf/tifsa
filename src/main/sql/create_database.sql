CREATE DATABASE IF NOT EXISTS tifsa;

USE tifsa;

CREATE TABLE `AddCountry` (
  `AddCountryID` int(11) NOT NULL AUTO_INCREMENT,
  `AddCountryName` varchar(255) NOT NULL,
  PRIMARY KEY (`AddCountryID`),
  UNIQUE KEY `AddCountry_AddCountryID_uindex` (`AddCountryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lookup table for countries in addresses'

CREATE TABLE `AddState` (
  `AddStateID` int(11) NOT NULL AUTO_INCREMENT,
  `AddCountryID` int(11) NOT NULL,
  `AddStateName` varchar(255) NOT NULL,
  `AddStateAbbreviation` varchar(2) NOT NULL,
  PRIMARY KEY (`AddStateID`),
  UNIQUE KEY `AddState_AddStateID_uindex` (`AddStateID`),
  KEY `AddState_AddCountry_AddCountryID_fk` (`AddCountryID`),
  CONSTRAINT `AddState_AddCountry_AddCountryID_fk` FOREIGN KEY (`AddCountryID`) REFERENCES `AddCountry` (`AddCountryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Lookup table for states in addresses'