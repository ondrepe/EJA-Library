SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `Library` ;
CREATE SCHEMA IF NOT EXISTS `Library` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci ;
USE `Library` ;

-- -----------------------------------------------------
-- Table `Library`.`Reader`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Reader` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Reader` (
  `idReader` INT NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  `email` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idReader`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Author` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Author` (
  `idAuthor` INT NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idAuthor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Publisher` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Publisher` (
  `idPublisher` INT NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idPublisher`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`BookTitle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`BookTitle` ;

CREATE  TABLE IF NOT EXISTS `Library`.`BookTitle` (
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
    REFERENCES `Library`.`Publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Category` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Category` (
  `idCategory` INT NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idCategory`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`CategoryBook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`CategoryBook` ;

CREATE  TABLE IF NOT EXISTS `Library`.`CategoryBook` (
  `idCategoryBook` INT NOT NULL ,
  `idCategory` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  PRIMARY KEY (`idCategoryBook`) ,
  INDEX `fk_BookInCategory_Category1` (`idCategory` ASC) ,
  INDEX `fk_CategoryBook_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_BookInCategory_Category1`
    FOREIGN KEY (`idCategory` )
    REFERENCES `Library`.`Category` (`idCategory` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CategoryBook_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `Library`.`BookTitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`AuthorBook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`AuthorBook` ;

CREATE  TABLE IF NOT EXISTS `Library`.`AuthorBook` (
  `idAuthorBook` INT NOT NULL ,
  `idAuthor` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  PRIMARY KEY (`idAuthorBook`) ,
  INDEX `fk_AuthorBook_Author1` (`idAuthor` ASC) ,
  INDEX `fk_AuthorBook_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_AuthorBook_Author1`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `Library`.`Author` (`idAuthor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AuthorBook_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `Library`.`BookTitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Commentary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Commentary` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Commentary` (
  `idCommentary` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  `authorName` VARCHAR(50) NOT NULL ,
  `time` DATETIME NOT NULL ,
  `text` TEXT NOT NULL ,
  PRIMARY KEY (`idCommentary`) ,
  INDEX `fk_Commentary_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_Commentary_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `Library`.`BookTitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`LibraryUnit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`LibraryUnit` ;

CREATE  TABLE IF NOT EXISTS `Library`.`LibraryUnit` (
  `idLibraryUnit` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  PRIMARY KEY (`idLibraryUnit`) ,
  INDEX `fk_LibraryUnit_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_LibraryUnit_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `Library`.`BookTitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`ChargeOutStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`ChargeOutStatus` ;

CREATE  TABLE IF NOT EXISTS `Library`.`ChargeOutStatus` (
  `idChargeOutStatus` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idChargeOutStatus`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`ChargeOut`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`ChargeOut` ;

CREATE  TABLE IF NOT EXISTS `Library`.`ChargeOut` (
  `idChargeOut` INT NOT NULL ,
  `idLibraryUnit` INT NOT NULL ,
  `idReader` INT NOT NULL ,
  `fromDate` DATETIME NOT NULL ,
  `toDate` DATETIME NOT NULL ,
  `status` INT NOT NULL ,
  PRIMARY KEY (`idChargeOut`) ,
  INDEX `fk_Borrowing_Book1` (`idLibraryUnit` ASC) ,
  INDEX `fk_Borrowing_Reader1` (`idReader` ASC) ,
  INDEX `fk_ChargeOut_ChargeOutStatus1` (`status` ASC) ,
  CONSTRAINT `fk_Borrowing_Book1`
    FOREIGN KEY (`idLibraryUnit` )
    REFERENCES `Library`.`LibraryUnit` (`idLibraryUnit` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrowing_Reader1`
    FOREIGN KEY (`idReader` )
    REFERENCES `Library`.`Reader` (`idReader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ChargeOut_ChargeOutStatus1`
    FOREIGN KEY (`status` )
    REFERENCES `Library`.`ChargeOutStatus` (`idChargeOutStatus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Authorization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Authorization` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Authorization` (
  `login` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  `idReader` INT NULL ,
  PRIMARY KEY (`login`) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) ,
  INDEX `fk_Authorization_Reader1` (`idReader` ASC) ,
  CONSTRAINT `fk_Authorization_Reader1`
    FOREIGN KEY (`idReader` )
    REFERENCES `Library`.`Reader` (`idReader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Score`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Score` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Score` (
  `idScore` INT NOT NULL ,
  `idBookTitle` INT NOT NULL ,
  `value` INT NOT NULL ,
  `data` VARCHAR(100) NULL ,
  PRIMARY KEY (`idScore`) ,
  INDEX `fk_Score_BookTitle1` (`idBookTitle` ASC) ,
  CONSTRAINT `fk_Score_BookTitle1`
    FOREIGN KEY (`idBookTitle` )
    REFERENCES `Library`.`BookTitle` (`idBookTitle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Parameter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Parameter` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Parameter` (
  `idParameter` INT NOT NULL ,
  `paramGroup` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `datatype` VARCHAR(1) NOT NULL ,
  `about` VARCHAR(200) NULL ,
  PRIMARY KEY (`idParameter`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Sequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Sequence` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Sequence` (
  `seq_name` VARCHAR(20) NOT NULL ,
  `seq_num` INT NOT NULL ,
  PRIMARY KEY (`seq_name`) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
