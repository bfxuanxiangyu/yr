package com.weeds.entity.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * rare_disease_classification 实体类
 * 罕见病分类
 * 由GenEntityMysql类自动生成
 * Fri Jul 01 08:34:42 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "rare_disease_classification")
public class RareDiseaseClassification implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 分类中文名
     */
    @Column(name = "classification_name_cn")
    protected String classificationNameCn;

    /**
     * 分类英文名
     */
    @Column(name = "classification_name_en")
    protected String classificationNameEn;

    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createTime;

    @Column(name = "create_by")
    protected String createBy;

    @Column(name = "last_update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date lastUpdateTime;

    @Column(name = "last_update_by")
    protected String lastUpdateBy;

    @Column(name = "delete_flag")
    protected Integer deleteFlag;
    
    @Transient
    protected Integer diseaseCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassificationNameCn() {
        return classificationNameCn;
    }

    public void setClassificationNameCn(String classificationNameCn) {
        this.classificationNameCn = classificationNameCn;
    }

    public String getClassificationNameEn() {
        return classificationNameEn;
    }

    public void setClassificationNameEn(String classificationNameEn) {
        this.classificationNameEn = classificationNameEn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public Integer getDiseaseCount() {
		return diseaseCount;
	}

	public void setDiseaseCount(Integer diseaseCount) {
		this.diseaseCount = diseaseCount;
	}

}

