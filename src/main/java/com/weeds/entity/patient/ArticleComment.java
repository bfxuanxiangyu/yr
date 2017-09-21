package com.weeds.entity.patient;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.weeds.entity.expert.Expert;
import com.weeds.entity.expert.ExpertArticle;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * t_article_comment 实体类 由GenEntityMysql类自动生成 Wed Jun 01 14:06:45 CST 2016
 * 
 * @ZhangBing
 */
@Entity
@Table(name = "t_article_comment")
public class ArticleComment implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	protected String id;

	@Column(name = "create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	protected Date createTime;

	@Column(name = "update_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	protected Date updateTime;

	/**
	 * 评论内容
	 */
	@Column(name = "content")
	protected String content;

	/**
	 * 类型 1医生 2患者
	 */
	@Column(name = "type")
	protected Integer type;

	/**
	 * 文章id
	 */
	@Column(name = "article_id")
	protected String articleId;
	
	/**
	 * 录入者id
	 */
	@Column(name = "user_id")
	protected String userId;

	/**
	 * 评论状态   0未审核   1审核通过  2删除
	 */
	@Column(name = "status")
	protected Integer status;
	
	/**
	 * 患者
	 */
	@Transient
	protected Patient patient;
	/**
	 * 医生
	 */
	@Transient
	protected Expert expert;
	
	@Transient
	protected ExpertArticle expertArticle;
	
	@Transient
	protected Expert ea;//文章发布者对象
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ExpertArticle getExpertArticle() {
		return expertArticle;
	}

	public void setExpertArticle(ExpertArticle expertArticle) {
		this.expertArticle = expertArticle;
	}

	public Expert getEa() {
		return ea;
	}

	public void setEa(Expert ea) {
		this.ea = ea;
	}

}
