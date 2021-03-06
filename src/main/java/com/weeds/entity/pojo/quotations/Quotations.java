package com.weeds.entity.pojo.quotations;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat; 
/**
 * t_quotations 实体类
 * 由GenEntityMysql类自动生成
 * Wed Nov 23 14:36:23 CST 2016
 * @xuanxy
 */ 
@Entity
@Table(name="t_quotations")
public class Quotations {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;

	@Column(name="create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createTime;

	@Column(name="update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date updateTime;

	/**
	* 语录者
	*/ 
	@Column(name="user_id")
	private String userId;

	/**
	* 语录内容   限定150字
	*/ 
	@Column(name="content")
	private String content;

	/**
	* 数据状态  0正常   1删除
	*/ 
	@Column(name="delete_flag")
	private Integer deleteFlag;
	
	@Transient
	private String realName;//评论者名称

	@Transient
	private List<QuotationsComment> commentList;//语录评论列表
	
	@Transient
	private List<QuotationsLaud> laudList;//语录点赞列表

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

	public Date getCreateTime(){
		return createTime;
	}

	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}

	public Date getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content=content;
	}

	public Integer getDeleteFlag(){
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag=deleteFlag;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public List<QuotationsComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<QuotationsComment> commentList) {
		this.commentList = commentList;
	}

	public List<QuotationsLaud> getLaudList() {
		return laudList;
	}

	public void setLaudList(List<QuotationsLaud> laudList) {
		this.laudList = laudList;
	}

}

