
-- ------------------------------------------------------ 个人中心 ----------------------------------------------------
drop table if exists t_access_token;
drop table if exists t_user;

CREATE  TABLE IF NOT EXISTS `t_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `login_name` VARCHAR(64) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `salt` VARCHAR(45) NULL ,
  `nickname` VARCHAR(20) NULL ,
  `gender` CHAR(1) NULL DEFAULT 'f' COMMENT 'm：男、f：女' ,
  `birthday` VARCHAR(45) NULL COMMENT 'yyyy-mm-dd' ,
  `province` INT NULL ,
  `city` INT NULL ,
  `avatar_url` VARCHAR(45) NULL ,
  `intro` VARCHAR(255) NULL ,
  `update_time` DATETIME NULL ,
  `created_time` DATETIME NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `t_access_token` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `user_id` BIGINT NOT NULL ,
  `access_token` VARCHAR(45) NULL ,
  `expires_in` BIGINT NULL ,
  `refresh_token` VARCHAR(45) NULL ,
  `created_time` BIGINT NULL COMMENT '创建时间：毫秒' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_t_access_token_t_user` (`user_id` ASC) ,
  CONSTRAINT `fk_t_access_token_t_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `estarapp`.`t_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

