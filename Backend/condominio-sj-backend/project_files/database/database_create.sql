-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema condominio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema condominio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `condominio` DEFAULT CHARACTER SET utf8 ;
USE `condominio` ;

-- -----------------------------------------------------
-- Table `condominio`.`tb_apartamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_apartamento` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao_apartamento` VARCHAR(120) NOT NULL,
  `email_proprietario` VARCHAR(255) NOT NULL,
  `fone_proprietario` VARCHAR(255) NOT NULL,
  `nome_proprietario` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_s38lyy6ynpg4rjjerkhe9xbno` (`email_proprietario` ASC),
  UNIQUE INDEX `UK_pl4dpgeby2dddvs9vc13674ra` (`fone_proprietario` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_user` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(120) NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `id_user` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_4vih17mube9j7cqyjlfbcrk4m` (`email` ASC),
  INDEX `FK_7uui42jkdsf7vqmrwd7iyr1sp` (`id_user` ASC),
  CONSTRAINT `FK_7uui42jkdsf7vqmrwd7iyr1sp`
    FOREIGN KEY (`id_user`)
    REFERENCES `condominio`.`tb_apartamento` (`pk_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_agendamento` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `agenda_data` VARCHAR(120) NOT NULL,
  `agenda_descricao` VARCHAR(255) NOT NULL,
  `agenda_empresa` VARCHAR(120) NOT NULL,
  `agenda_hora` VARCHAR(120) NOT NULL,
  `agenda_user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_67dm9twi3leycq7f53gg41s20` (`agenda_user_id` ASC),
  CONSTRAINT `FK_67dm9twi3leycq7f53gg41s20`
    FOREIGN KEY (`agenda_user_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_alugar_apartamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_alugar_apartamento` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_valor` VARCHAR(10) NOT NULL,
  `alugar_ape_user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_3l0phwy0e5vxfjhx57b0i56u4` (`alugar_ape_user_id` ASC),
  CONSTRAINT `FK_3l0phwy0e5vxfjhx57b0i56u4`
    FOREIGN KEY (`alugar_ape_user_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_alugar_garagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_alugar_garagem` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cnh_cliente` VARCHAR(120) NOT NULL,
  `cor_veiculo_cliente` VARCHAR(120) NOT NULL,
  `data_final_cliente` VARCHAR(120) NOT NULL,
  `data_inicial_cliente` VARCHAR(120) NOT NULL,
  `descricao_cliente` VARCHAR(255) NOT NULL,
  `modelo_veiculo_cliente` VARCHAR(120) NOT NULL,
  `motorista_cliente` VARCHAR(120) NOT NULL,
  `placa_veiculo_cliente` VARCHAR(120) NOT NULL,
  `aluguel_user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_fp2cjc59435odd333r86lyf31` (`aluguel_user_id` ASC),
  CONSTRAINT `FK_fp2cjc59435odd333r86lyf31`
    FOREIGN KEY (`aluguel_user_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_bicicleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_bicicleta` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cor_bicicleta` VARCHAR(120) NOT NULL,
  `dono_bicicleta` VARCHAR(120) NOT NULL,
  `modelo_bicicleta` VARCHAR(120) NOT NULL,
  `ap_id_b` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_81kbnk9vh1b37itcqt7v74d03` (`ap_id_b` ASC),
  CONSTRAINT `FK_81kbnk9vh1b37itcqt7v74d03`
    FOREIGN KEY (`ap_id_b`)
    REFERENCES `condominio`.`tb_apartamento` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_caixa` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_gerente` VARCHAR(120) NOT NULL,
  `register_date` DATETIME NOT NULL,
  `tb_valor` DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_foto_alugar_ape`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_foto_alugar_ape` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_comodo` VARCHAR(120) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `ap_id_alugar` BIGINT(20) NULL DEFAULT NULL,
  `fotos_ape_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_bxwo6ey4jibqvrjo3tlfrcyl5` (`ap_id_alugar` ASC),
  INDEX `FK_2drew7u4wa88h0956k3ce5dn7` (`fotos_ape_id` ASC),
  CONSTRAINT `FK_2drew7u4wa88h0956k3ce5dn7`
    FOREIGN KEY (`fotos_ape_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`),
  CONSTRAINT `FK_bxwo6ey4jibqvrjo3tlfrcyl5`
    FOREIGN KEY (`ap_id_alugar`)
    REFERENCES `condominio`.`tb_alugar_apartamento` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_vender_apartamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_vender_apartamento` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `valor` VARCHAR(255) NULL DEFAULT NULL,
  `vender_ape_user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_3occdn9cbhlkqboj2ap8kvqgv` (`vender_ape_user_id` ASC),
  CONSTRAINT `FK_3occdn9cbhlkqboj2ap8kvqgv`
    FOREIGN KEY (`vender_ape_user_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_foto_venda_ape`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_foto_venda_ape` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_venda_comodo` VARCHAR(120) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `userape_id` BIGINT(20) NULL DEFAULT NULL,
  `apid_alugar` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_tbf4ktem7pww212fr4ig5bi2n` (`userape_id` ASC),
  INDEX `FK_n1bfkhdafvfdgk3bvjos7b6fv` (`apid_alugar` ASC),
  CONSTRAINT `FK_n1bfkhdafvfdgk3bvjos7b6fv`
    FOREIGN KEY (`apid_alugar`)
    REFERENCES `condominio`.`tb_vender_apartamento` (`pk_id`),
  CONSTRAINT `FK_tbf4ktem7pww212fr4ig5bi2n`
    FOREIGN KEY (`userape_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_funcionario` (
  `id_funcionario` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cpf_funcionario` VARCHAR(255) NOT NULL,
  `email_funcionario` VARCHAR(255) NOT NULL,
  `empresa_funcionario` VARCHAR(120) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `fone_funcionario` VARCHAR(120) NOT NULL,
  `funcao_funcionario` VARCHAR(120) NOT NULL,
  `nome_funcionario` VARCHAR(120) NOT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `rg_funcionario` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE INDEX `UK_41rxtr6e6xvseala25hb5ar2g` (`cpf_funcionario` ASC),
  UNIQUE INDEX `UK_2xnc86xn3kky30p0ufd36x68t` (`email_funcionario` ASC),
  UNIQUE INDEX `UK_1wmpgqe5rboe4sq7ip2i771x0` (`rg_funcionario` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_morador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_morador` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email_morador` VARCHAR(255) NOT NULL,
  `fone_morador` VARCHAR(255) NOT NULL,
  `nome_morador` VARCHAR(120) NOT NULL,
  `ap_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_bgqtcr5odelryhkq584a8jaih` (`email_morador` ASC),
  UNIQUE INDEX `UK_2k0n0u4dwfcee7bi1g8ucu5t7` (`fone_morador` ASC),
  INDEX `FK_shrn02y9wd78ag9d5r1kuwq9o` (`ap_id` ASC),
  CONSTRAINT `FK_shrn02y9wd78ag9d5r1kuwq9o`
    FOREIGN KEY (`ap_id`)
    REFERENCES `condominio`.`tb_apartamento` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_permission` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pk_id`),
  UNIQUE INDEX `UK_rwvnf9dhenmknvljgery79idd` (`role` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_prestador_servico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_prestador_servico` (
  `id_prestador_servico` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cpf_ps` VARCHAR(255) NOT NULL,
  `email_ps` VARCHAR(255) NOT NULL,
  `empresa_ps` VARCHAR(120) NOT NULL,
  `file` LONGBLOB NULL DEFAULT NULL,
  `fone_ps` VARCHAR(120) NOT NULL,
  `funcao_ps` VARCHAR(120) NOT NULL,
  `mime_type` VARCHAR(255) NULL DEFAULT NULL,
  `nome_ps` VARCHAR(120) NOT NULL,
  `rg_ps` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_prestador_servico`),
  UNIQUE INDEX `UK_9xoev1bwilcohvw3n4p7819lv` (`cpf_ps` ASC),
  UNIQUE INDEX `UK_8qjc6mdimxwbpmaygy9s7as7l` (`email_ps` ASC),
  UNIQUE INDEX `UK_3vjbdso7n7vod50fcggk0005u` (`rg_ps` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_prestar_conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_prestar_conta` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tb_descricao` VARCHAR(255) NOT NULL,
  `tb_empresa` VARCHAR(20) NOT NULL,
  `tb_funcionario` VARCHAR(20) NOT NULL,
  `register_date` DATETIME NOT NULL,
  `tb_valor_servico` DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_user_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_user_permission` (
  `permission_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`permission_id`, `user_id`),
  INDEX `FK_l6cvhr5w2r9ff429fa5eqxmyo` (`user_id` ASC),
  CONSTRAINT `FK_44w3gaqxmtfvn2xslng1a5pi0`
    FOREIGN KEY (`permission_id`)
    REFERENCES `condominio`.`tb_permission` (`pk_id`),
  CONSTRAINT `FK_l6cvhr5w2r9ff429fa5eqxmyo`
    FOREIGN KEY (`user_id`)
    REFERENCES `condominio`.`tb_user` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`tb_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`tb_veiculo` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cnh_veiculo` VARCHAR(120) NOT NULL,
  `cor_veiculo` VARCHAR(120) NOT NULL,
  `modelo_veiculo` VARCHAR(120) NOT NULL,
  `motorista_veiculo` VARCHAR(120) NOT NULL,
  `placa_veiculo` VARCHAR(120) NOT NULL,
  `ap_id_v` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`),
  INDEX `FK_t4gxmpdhojdm4th1c7n6yv31c` (`ap_id_v` ASC),
  CONSTRAINT `FK_t4gxmpdhojdm4th1c7n6yv31c`
    FOREIGN KEY (`ap_id_v`)
    REFERENCES `condominio`.`tb_apartamento` (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `condominio`.`td_ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `condominio`.`td_ocorrencia` (
  `pk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `register_date` DATETIME NOT NULL,
  `tb_registro` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`pk_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
