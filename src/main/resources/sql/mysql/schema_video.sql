drop table if exists t_category;
-- 分类表
CREATE  TABLE IF NOT EXISTS `t_category` (
  `cat_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '分类id' ,
  `cat_name` VARCHAR(45) NOT NULL COMMENT '分类名称' ,
  `parent_id` BIGINT NULL COMMENT '分类父id,顶级分类为-1' ,
  `parent_path` VARCHAR(45) NULL COMMENT '父节点路径：1,2,4' ,
  `ord` INT NULL COMMENT '排序' ,
  `image` VARCHAR(200) NULL COMMENT '缩略图' ,
  `remark` VARCHAR(45) NULL COMMENT '备注' ,
  `webcat_id` VARCHAR(45) NULL COMMENT '网站分类id' ,
  PRIMARY KEY (`cat_id`) ,
  INDEX `category_parentpath_index` (`parent_path` ASC) ,
  INDEX `category_orderpath_index` (`ord` ASC) ,
  INDEX `parent_id_index` (`parent_id` ASC) )
ENGINE = InnoDB;

-- 视频表
drop table if exists t_video_cat;
drop table if exists t_video;
CREATE  TABLE IF NOT EXISTS `t_video` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(200) NOT NULL ,
  `screen_small` VARCHAR(200) NULL COMMENT '视频截图(小)100x100' ,
  `screen_big` VARCHAR(200) NULL COMMENT '视频截图(大)500' ,
  `webvideo_id` VARCHAR(20) NOT NULL COMMENT '网站视频id，通过网站获取视频信息' ,
  `update_time` DATETIME NULL ,
  `created_time` DATETIME NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- 视频分类关系表
CREATE  TABLE IF NOT EXISTS `t_video_cat` (
  `video_id` BIGINT NOT NULL COMMENT '视频id' ,
  `cat_id` BIGINT NOT NULL ,
  `cat_path` VARCHAR(45) NULL COMMENT '分类路径:包含父级' ,
  PRIMARY KEY (`video_id`, `cat_id`) ,
  INDEX `fk_t_video_cat_t_video1` (`video_id` ASC) ,
  INDEX `cat_path_index` (`cat_path` ASC) ,
  INDEX `cat_id_index` (`cat_id` ASC) ,
  CONSTRAINT `fk_t_video_cat_t_video1`
    FOREIGN KEY (`video_id` )
    REFERENCES `u9dota`.`t_video` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- 推荐视频表
drop table if exists t_video_recommend;
CREATE TABLE IF NOT EXISTS `t_video_recommend` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(200) NOT NULL ,
  `screen_middle` VARCHAR(200) NULL ,
  `screen_big` VARCHAR(200) NULL ,
  `webvideo_id` VARCHAR(45) NOT NULL COMMENT '网站视频id，通过网站获取视频信息' ,
  `update_time` DATETIME NULL ,
  `created_time` DATETIME NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

