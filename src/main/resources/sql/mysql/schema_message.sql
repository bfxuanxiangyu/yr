-- ------------------------------------------------------ 消息中心 ----------------------------------------------------
drop table if exists t_notification;
drop table if exists t_personal_letter;
-- 系统消息（ 通知）表
CREATE  TABLE IF NOT EXISTS `t_notification` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `user_id` BIGINT NULL COMMENT '用户id' ,
  `title` VARCHAR(45) NULL COMMENT '通知标题' ,
  `content` VARCHAR(100) NULL COMMENT '通知内容' ,
  `type` CHAR(1) NULL COMMENT '通知类型:根据类型跳转到不同的页面' ,
  `uri` VARCHAR(200) NULL COMMENT '外链' ,
  `status` INT NULL DEFAULT 0 COMMENT '状态：0-未读   1-已读' ,
  `send_time` DATETIME NULL COMMENT '通知时间' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- 私信表
CREATE  TABLE IF NOT EXISTS `t_personal_letter` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `user_id` BIGINT NOT NULL ,
  `friend_id` BIGINT NOT NULL ,
  `sender` BIGINT NOT NULL ,
  `receiver` BIGINT NOT NULL ,
  `content` VARCHAR(500) NOT NULL COMMENT '私信内容' ,
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '私信状态：0-未读  1-已读' ,
  `send_time` DATETIME NOT NULL COMMENT '发送时间' ,
  `read_time` DATETIME NULL COMMENT '阅读时间' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

