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
  `isbn` VARCHAR(100) NOT NULL ,
  `name` VARCHAR(2000) NOT NULL ,
  `idPublisher` INT NOT NULL ,
  `year` YEAR NULL ,
  `pagesCount` INT NULL ,
  `issueNumber` VARCHAR(50) NULL ,
  `about` TEXT NULL ,
  `score` INT NULL ,
  PRIMARY KEY (`isbn`) ,
  INDEX `fk_BookTitle_Publisher` (`idPublisher` ASC) ,
  CONSTRAINT `fk_BookTitle_Publisher`
    FOREIGN KEY (`idPublisher` )
    REFERENCES `Library`.`Publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Spojovací tabulka, která určuje do jakých kategorii patří kníha';


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
  `isbn` VARCHAR(100) NOT NULL ,
  `idCategory` INT NOT NULL ,
  PRIMARY KEY (`idCategoryBook`) ,
  INDEX `fk_BookInCategory_BookTitle1` (`isbn` ASC) ,
  INDEX `fk_BookInCategory_Category1` (`idCategory` ASC) ,
  CONSTRAINT `fk_BookInCategory_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_BookInCategory_Category1`
    FOREIGN KEY (`idCategory` )
    REFERENCES `Library`.`Category` (`idCategory` )
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
  `isbn` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idAuthorBook`) ,
  INDEX `fk_AuthorBook_Author1` (`idAuthor` ASC) ,
  INDEX `fk_AuthorBook_BookTitle1` (`isbn` ASC) ,
  CONSTRAINT `fk_AuthorBook_Author1`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `Library`.`Author` (`idAuthor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AuthorBook_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Spojovací tabulka, která určuje kdo napsal jakou knihu';


-- -----------------------------------------------------
-- Table `Library`.`Comentary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Comentary` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Comentary` (
  `idComentary` INT NOT NULL ,
  `authorName` VARCHAR(50) NOT NULL ,
  `time` DATETIME NOT NULL ,
  `text` TEXT NOT NULL ,
  PRIMARY KEY (`idComentary`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`ComentaryBook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`ComentaryBook` ;

CREATE  TABLE IF NOT EXISTS `Library`.`ComentaryBook` (
  `idComentaryBook` INT NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  `idComentary` INT NOT NULL ,
  PRIMARY KEY (`idComentaryBook`) ,
  INDEX `fk_ComentaryBook_BookTitle1` (`isbn` ASC) ,
  INDEX `fk_ComentaryBook_Comentary1` (`idComentary` ASC) ,
  CONSTRAINT `fk_ComentaryBook_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ComentaryBook_Comentary1`
    FOREIGN KEY (`idComentary` )
    REFERENCES `Library`.`Comentary` (`idComentary` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Book` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Book` (
  `idBook` INT NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idBook`) ,
  INDEX `fk_Book_BookTitle1` (`isbn` ASC) ,
  CONSTRAINT `fk_Book_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Library`.`Borrowing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Library`.`Borrowing` ;

CREATE  TABLE IF NOT EXISTS `Library`.`Borrowing` (
  `idBorrowing` INT NOT NULL ,
  `Book_idBook` INT NOT NULL ,
  `Reader_idReader` INT NOT NULL ,
  `From` DATETIME NOT NULL ,
  `To` DATETIME NOT NULL ,
  PRIMARY KEY (`idBorrowing`) ,
  INDEX `fk_Borrowing_Book1` (`Book_idBook` ASC) ,
  INDEX `fk_Borrowing_Reader1` (`Reader_idReader` ASC) ,
  CONSTRAINT `fk_Borrowing_Book1`
    FOREIGN KEY (`Book_idBook` )
    REFERENCES `Library`.`Book` (`idBook` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrowing_Reader1`
    FOREIGN KEY (`Reader_idReader` )
    REFERENCES `Library`.`Reader` (`idReader` )
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
  PRIMARY KEY (`login`) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
