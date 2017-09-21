-- ------------------------------------------------------ 数据统计分析 ----------------------------------------------------

drop table if exists t_device;
CREATE  TABLE IF NOT EXISTS `t_device` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `user_id` BIGINT NOT NULL ,
  `device_id` VARCHAR(100) NULL COMMENT '设备号' ,
  `os_name` VARCHAR(45) NULL COMMENT '操作系统名称：iOS   Android  WindowsPhone' ,
  `os_version` VARCHAR(45) NULL COMMENT '操作系统版本号：' ,
  `device_model` VARCHAR(100) NULL COMMENT '设备型号如：三星GT-S5830' ,
  `resolution_ratio` VARCHAR(45) NULL COMMENT '分辨率如：480*800' ,
  `created_time` DATETIME NULL COMMENT '添加时间' ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_t_device_t_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_t_device_t_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `estarapp`.`t_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

