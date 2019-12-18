-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fooddb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fooddb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fooddb` DEFAULT CHARACTER SET utf8 ;
USE `fooddb` ;

-- -----------------------------------------------------
-- Table `fooddb`.`cookedfood`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fooddb`.`cookedfood` (
  `code` VARCHAR(45) NOT NULL,
  `food_group` VARCHAR(45) NULL,
  `name` VARCHAR(100) NULL,
  `supportpareat` VARCHAR(45) NULL,
  `calory` VARCHAR(45) NULL,
  `carbo` VARCHAR(45) NULL,
  `protein` VARCHAR(45) NULL,
  `fat` VARCHAR(45) NULL,
  `sugar` VARCHAR(45) NULL,
  `natrium` VARCHAR(45) NULL,
  `chole` VARCHAR(45) NULL,
  `fattyacid` VARCHAR(45) NULL,
  `transfat` VARCHAR(45) NULL,
  `year` VARCHAR(45) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

# 엑셀데이터 디비에 넣는 방법
# 1. LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/OPENDATA_FOOD_2.csv' INTO TABLE cookedfood FIELDS TERMINATED BY ','; -> 에러나면 2번
# 2. show variables like "secure_file_priv" -> 로 파일 넣을 경로 찾고 엑셀 파일에 넣어주면 됨
