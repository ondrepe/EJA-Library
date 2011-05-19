SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `library` ;
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`reader`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`reader` ;

CREATE  TABLE IF NOT EXISTS `library`.`reader` (
  `idReader` INT NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  `email` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idReader`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`author` ;

CREATE  TABLE IF NOT EXISTS `library`.`author` (
  `idAuthor` INT NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idAuthor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`publisher` ;

CREATE  TABLE IF NOT EXISTS `library`.`publisher` (
  `idPublisher` INT NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idPublisher`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`booktitle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`booktitle` ;

CREATE  TABLE IF NOT EXISTS `library`.`booktitle` (
  `idBookTitle` INT NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  `name` VARCHAR(2000) NOT NULL ,
  `idPublisher` INT NOT NULL ,
  `year` YEAR NULL ,
  `pagesCount` INT NULL ,
  `issueNumber` VARCHAR(50) NULL ,
  `about` TEXT NULL ,
  INDEX `fk_BookTitle_Publisher` (`idPublisher` ASC) ,
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) ,
  PRIMARY KEY (`idBookTitle`) ,
  CONSTRAINT `fk_BookTitle_Publisher`
    FOREIGN KEY (`idPublisher` )
    REFERENCES `library`.`publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`category` ;

CREATE  TABLE IF NOT EXISTS `library`.`category` (
  `idCategory` INT NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idCategory`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`categorybook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`categorybook` ;

CREATE  TABLE IF NOT EXISTS `library`.`categorybook` (
  `idCategory` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  INDEX `fk_BookInCategory_Category1` (`idCategory` ASC) ,
  INDEX `fk_CategoryBook_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_BookInCategory_Category1`
    FOREIGN KEY (`idCategory` )
    REFERENCES `library`.`category` (`idCategory` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CategoryBook_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `library`.`booktitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`authorbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`authorbook` ;

CREATE  TABLE IF NOT EXISTS `library`.`authorbook` (
  `idAuthor` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  INDEX `fk_AuthorBook_Author1` (`idAuthor` ASC) ,
  INDEX `fk_AuthorBook_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_AuthorBook_Author1`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `library`.`author` (`idAuthor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AuthorBook_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `library`.`booktitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`commentary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`commentary` ;

CREATE  TABLE IF NOT EXISTS `library`.`commentary` (
  `idCommentary` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  `authorName` VARCHAR(50) NOT NULL ,
  `time` DATETIME NOT NULL ,
  `text` TEXT NOT NULL ,
  PRIMARY KEY (`idCommentary`) ,
  INDEX `fk_Commentary_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_Commentary_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `library`.`booktitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`libraryunit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`libraryunit` ;

CREATE  TABLE IF NOT EXISTS `library`.`libraryunit` (
  `idLibraryUnit` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  PRIMARY KEY (`idLibraryUnit`) ,
  INDEX `fk_LibraryUnit_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_LibraryUnit_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `library`.`booktitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`chargeoutstatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`chargeoutstatus` ;

CREATE  TABLE IF NOT EXISTS `library`.`chargeoutstatus` (
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`chargeout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`chargeout` ;

CREATE  TABLE IF NOT EXISTS `library`.`chargeout` (
  `idChargeOut` INT NOT NULL ,
  `idLibraryUnit` INT NOT NULL ,
  `idReader` INT NOT NULL ,
  `fromDate` DATETIME NOT NULL ,
  `toDate` DATETIME NOT NULL ,
  `status` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idChargeOut`) ,
  INDEX `fk_Borrowing_Book1` (`idLibraryUnit` ASC) ,
  INDEX `fk_Borrowing_Reader1` (`idReader` ASC) ,
  INDEX `fk_ChargeOut_ChargeOutStatus1` (`status` ASC) ,
  CONSTRAINT `fk_Borrowing_Book1`
    FOREIGN KEY (`idLibraryUnit` )
    REFERENCES `library`.`libraryunit` (`idLibraryUnit` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrowing_Reader1`
    FOREIGN KEY (`idReader` )
    REFERENCES `library`.`reader` (`idReader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChargeOut_ChargeOutStatus1`
    FOREIGN KEY (`status` )
    REFERENCES `library`.`chargeoutstatus` (`name` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`autentizationgroup`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`autentizationgroup` ;

CREATE  TABLE IF NOT EXISTS `library`.`autentizationgroup` (
  `groupName` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`groupName`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`autentization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`autentization` ;

CREATE  TABLE IF NOT EXISTS `library`.`autentization` (
  `login` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `groupName` VARCHAR(20) NOT NULL ,
  `idReader` INT NULL ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  INDEX `fk_Authorization_Reader1` (`idReader` ASC) ,
  INDEX `fk_Authorization_autentizationgroup1` (`groupName` ASC) ,
  PRIMARY KEY (`login`) ,
  CONSTRAINT `fk_Authorization_Reader1`
    FOREIGN KEY (`idReader` )
    REFERENCES `library`.`reader` (`idReader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Authorization_autentizationgroup1`
    FOREIGN KEY (`groupName` )
    REFERENCES `library`.`autentizationgroup` (`groupName` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`score`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`score` ;

CREATE  TABLE IF NOT EXISTS `library`.`score` (
  `idScore` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  `value` INT NOT NULL ,
  `data` VARCHAR(100) NULL ,
  PRIMARY KEY (`idScore`) ,
  INDEX `fk_Score_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_Score_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `library`.`booktitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`parameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`parameter` ;

CREATE  TABLE IF NOT EXISTS `library`.`parameter` (
  `idParameter` INT NOT NULL ,
  `paramgroup` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `datatype` VARCHAR(1) NOT NULL ,
  `about` VARCHAR(200) NULL ,
  PRIMARY KEY (`idParameter`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`idtable`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`idtable` ;

CREATE  TABLE IF NOT EXISTS `library`.`idtable` (
  `name` VARCHAR(20) NOT NULL ,
  `val` INT NOT NULL ,
  PRIMARY KEY (`name`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `library`.`chargeoutstatus`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `library`;
INSERT INTO `library`.`chargeoutstatus` (`name`) VALUES ('ACTIVE');
INSERT INTO `library`.`chargeoutstatus` (`name`) VALUES ('RESERVED');
INSERT INTO `library`.`chargeoutstatus` (`name`) VALUES ('RETURNED');

COMMIT;

-- -----------------------------------------------------
-- Data for table `library`.`autentizationgroup`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `library`;
INSERT INTO `library`.`autentizationgroup` (`groupName`) VALUES ('ADMIN');
INSERT INTO `library`.`autentizationgroup` (`groupName`) VALUES ('READER');

COMMIT;

-- -----------------------------------------------------
-- Data for table `library`.`autentization`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `library`;
INSERT INTO `library`.`autentization` (`login`, `password`, `groupName`, `idReader`) VALUES ('karel', '2cd324f30dc548396570da4e637c53ee', 'ADMIN', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `library`.`idtable`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
USE `library`;
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('reader', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('chargeout', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('score', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('author', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('publisher', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('booktitle', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('category', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('commentary', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('libraryunit', 10000);
INSERT INTO `library`.`idtable` (`name`, `val`) VALUES ('parameter', 10000);

COMMIT;
