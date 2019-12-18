CREATE TABLE `fooddb`.`foodmaterial` (
  `no` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `food_material` VARCHAR(1000) NULL,
  PRIMARY KEY (`no`));
  
ALTER TABLE `fooddb`.`foodmaterial` 
CHANGE COLUMN `no` `no` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `fooddb`.`foodmaterial` 
ADD COLUMN `recipe` VARCHAR(2000) NULL AFTER `food_material`,
ADD COLUMN `img` VARCHAR(500) NULL AFTER `recipe`;