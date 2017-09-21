package com.weeds.entity.expert;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * expert_article 实体类
 * 专家发布的文章内容
 * Fri Apr 01 18:51:31 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "expert_article")
public class ExpertArticle {

    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 创建人
     */
    @Column(name = "c_create_by")
    protected String cCreateBy;

    /**
     * 创建时间
     */
    @Column(name = "c_create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cCreateDate;

    /**
     * 更新人
     */
    @Column(name = "c_update_by")
    protected String cUpdateBy;

    /**
     * 更新时间
     */
    @Column(name = "c_update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cUpdateDate;

    /**
     * 删除标记：0-未删除，1-已删除
     */
    @Column(name = "c_delete_flag")
    protected Integer cDeleteFlag;

    /**
     * 专家ID
     */
    @Column(name = "c_expert_id")
    protected String cExpertId;

    /**
     * 栏目类型ID
     */
    @Column(name = "c_part_id")
    protected String cPartId;

    /**
     * 标题
     */
    @Column(name = "c_title")
    protected String cTitle;

    /**
     * banner图片
     */
    @Column(name = "c_photo")
    protected String cPhoto;

    /**
     * 内容摘要
     */
    @Column(name = "c_summary")
    protected String cSummary;

    /**
     * 内容
     */
    @Column(name = "c_content")
    protected String cContent;

    /**
     * 0:未发布  1：已发布
     */
    @Column(name = "is_publish")
    protected Integer isPublish;

    /**
     * 0:不再手机端显示  2：在手机端显示
     */
    @Column(name = "show_phone")
    protected Integer showPhone;
    
    /**
     * 文章点击次数
     */
    @Column(name = "C_HIT_COUNT")
    protected Long cHitCount;
    
    /**
     * 文章类型   1原创    2url链接
     */
    @Column(name = "C_ARTICLE_TYPE")
    protected Integer cArticleType;
    
    /**
     * 数据来源   0 pc端    1手机端
     */
    @Column(name = "C_SOURCE")
    protected Integer cSource;

    /**
     * 页面显示字段   超过999显示999+
     */
    @Transient
    protected String hitCount;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getcCreateBy() {
        return cCreateBy;
    }

    public void setcCreateBy(String cCreateBy) {
        this.cCreateBy = cCreateBy;
    }

    public Date getcCreateDate() {
        return cCreateDate;
    }

    public void setcCreateDate(Date cCreateDate) {
        this.cCreateDate = cCreateDate;
    }

    public String getcUpdateBy() {
        return cUpdateBy;
    }

    public void setcUpdateBy(String cUpdateBy) {
        this.cUpdateBy = cUpdateBy;
    }

    public Date getcUpdateDate() {
        return cUpdateDate;
    }

    public void setcUpdateDate(Date cUpdateDate) {
        this.cUpdateDate = cUpdateDate;
    }

    public Integer getcDeleteFlag() {
        return cDeleteFlag;
    }

    public void setcDeleteFlag(Integer cDeleteFlag) {
        this.cDeleteFlag = cDeleteFlag;
    }

    public String getcExpertId() {
        return cExpertId;
    }

    public void setcExpertId(String cExpertId) {
        this.cExpertId = cExpertId;
    }

    public String getcPartId() {
        return cPartId;
    }

    public void setcPartId(String cPartId) {
        this.cPartId = cPartId;
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getShowPhone() {
        return showPhone;
    }

    public void setShowPhone(Integer showPhone) {
        this.showPhone = showPhone;
    }

	public Long getcHitCount() {
		return cHitCount;
	}

	public void setcHitCount(Long cHitCount) {
		this.cHitCount = cHitCount;
	}

	public String getHitCount() {
		return hitCount;
	}

	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}

	public Integer getcArticleType() {
		return cArticleType;
	}

	public void setcArticleType(Integer cArticleType) {
		this.cArticleType = cArticleType;
	}

	public Integer getcSource() {
		return cSource;
	}

	public void setcSource(Integer cSource) {
		this.cSource = cSource;
	}

}

