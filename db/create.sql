SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Library` DEFAULT CHARACTER SET utf8 COLLATE utf8_czech_ci ;

USE `Library`;

CREATE  TABLE IF NOT EXISTS `Library`.`Reader` (
  `idReader` INT(11) NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  `email` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idReader`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Author` (
  `idAuthor` INT(11) NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `surname` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idAuthor`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Publisher` (
  `idPublisher` INT(11) NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idPublisher`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`BookTitle` (
  `isbn` VARCHAR(100) NOT NULL ,
  `name` VARCHAR(2000) NOT NULL ,
  `idPublisher` INT(11) NOT NULL ,
  `year` YEAR NULL DEFAULT NULL ,
  `pagesCount` INT(11) NULL DEFAULT NULL ,
  `issueNumber` VARCHAR(50) NULL DEFAULT NULL ,
  `about` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`isbn`) ,
  INDEX `fk_BookTitle_Publisher` (`idPublisher` ASC) ,
  CONSTRAINT `fk_BookTitle_Publisher`
    FOREIGN KEY (`idPublisher` )
    REFERENCES `Library`.`Publisher` (`idPublisher` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Category` (
  `idCategory` INT(11) NOT NULL ,
  `name` VARCHAR(250) NOT NULL ,
  PRIMARY KEY (`idCategory`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`CategoryBook` (
  `idCategoryBook` INT(11) NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  `idCategory` INT(11) NOT NULL ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`AuthorBook` (
  `idAuthorBook` INT(11) NOT NULL ,
  `idAuthor` INT(11) NOT NULL ,
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
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Commentary` (
  `idCommentary` INT(11) NOT NULL ,
  `authorName` VARCHAR(50) NOT NULL ,
  `time` DATETIME NOT NULL ,
  `text` TEXT NOT NULL ,
  PRIMARY KEY (`idCommentary`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`CommentaryBook` (
  `idCommentaryBook` INT(11) NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  `idCommentary` INT(11) NOT NULL ,
  PRIMARY KEY (`idCommentaryBook`) ,
  INDEX `fk_ComentaryBook_BookTitle1` (`isbn` ASC) ,
  INDEX `fk_ComentaryBook_Comentary1` (`idCommentary` ASC) ,
  CONSTRAINT `fk_ComentaryBook_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ComentaryBook_Comentary1`
    FOREIGN KEY (`idCommentary` )
    REFERENCES `Library`.`Commentary` (`idCommentary` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`LibraryUnit` (
  `idLibraryUnit` INT(11) NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idLibraryUnit`) ,
  INDEX `fk_Book_BookTitle1` (`isbn` ASC) ,
  CONSTRAINT `fk_Book_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`ChargeOut` (
  `idChargeOut` INT(11) NOT NULL ,
  `idLibraryUnit` INT(11) NOT NULL ,
  `idReader` INT(11) NOT NULL ,
  `fromDate` DATETIME NOT NULL ,
  `toDate` DATETIME NOT NULL ,
  PRIMARY KEY (`idChargeOut`) ,
  INDEX `fk_Borrowing_Book1` (`idLibraryUnit` ASC) ,
  INDEX `fk_Borrowing_Reader1` (`idReader` ASC) ,
  CONSTRAINT `fk_Borrowing_Book1`
    FOREIGN KEY (`idLibraryUnit` )
    REFERENCES `Library`.`LibraryUnit` (`idLibraryUnit` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrowing_Reader1`
    FOREIGN KEY (`idReader` )
    REFERENCES `Library`.`Reader` (`idReader` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Authorization` (
  `login` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`login`) ,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;

CREATE  TABLE IF NOT EXISTS `Library`.`Score` (
  `idScore` INT(11) NOT NULL ,
  `isbn` VARCHAR(100) NOT NULL ,
  `value` INT(11) NOT NULL ,
  `data` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`idScore`) ,
  INDEX `fk_Score_BookTitle1` (`isbn` ASC) ,
  CONSTRAINT `fk_Score_BookTitle1`
    FOREIGN KEY (`isbn` )
    REFERENCES `Library`.`BookTitle` (`isbn` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_czech_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
