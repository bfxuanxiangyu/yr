package com.weeds.entity.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * drug_classification 实体类
 * 药物作用分类
 * 由GenEntityMysql类自动生成
 * Sat Jul 16 15:43:52 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "drug_classification")
public class DrugClassification implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 药物大类id
     */
    @Column(name = "drug_categories_id")
    protected String drugCategoriesId;

    /**
     * 药物作用分类名称
     */
    @Column(name = "drug_classification_name")
    protected String drugClassificationName;

    @Column(name = "delete_flag")
    protected Integer deleteFlag;

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrugCategoriesId() {
        return drugCategoriesId;
    }

    public void setDrugCategoriesId(String drugCategoriesId) {
        this.drugCategoriesId = drugCategoriesId;
    }

    public String getDrugClassificationName() {
        return drugClassificationName;
    }

    public void setDrugClassificationName(String drugClassificationName) {
        this.drugClassificationName = drugClassificationName;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

}

