INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('READER_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('BOOKTITLE_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('LIBUNIT_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('AUTHOR_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('AUTHORBOOK_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('AUTHORIZATION_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('CATEGORYBOOK_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('CATEGORY_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('CHARGEOUT_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('COMMENTARY_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('SCORE_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('PARAMETER_SEQ', 10000);
INSERT INTO `Library`.`Sequence`(seq_name, seq_num) VALUES('PUBLISHER_SEQ', 10000);

INSERT INTO `Library`.`ChargeOutStatus`(idChargeOutStatus, name) VALUES(1, 'Rezervace');
INSERT INTO `Library`.`ChargeOutStatus`(idChargeOutStatus, name) VALUES(2, 'Vypujèeno');
INSERT INTO `Library`.`ChargeOutStatus`(idChargeOutStatus, name) VALUES(3, 'Vráceno');