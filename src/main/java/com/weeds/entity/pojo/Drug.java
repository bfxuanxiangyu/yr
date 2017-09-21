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
 * drug 实体类
 * 药物
 * 由GenEntityMysql类自动生成
 * Sat Jul 16 15:44:24 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "drug")
public class Drug implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 药物作用分类id
     */
    @Column(name = "drug_classification_id")
    protected String drugClassificationId;

    /**
     * 药物大类id
     */
    @Column(name = "drug_categories_id")
    protected String drugCategoriesId;

    /**
     * 药物类别id
     */
    @Column(name = "drug_category_id")
    protected String drugCategoryId;

    /**
     * 中西药分类id
     */
    @Column(name = "wc_drug_type_id")
    protected String wcDrugTypeId;

    /**
     * 药物名称
     */
    @Column(name = "drug_name")
    protected String drugName;

    /**
     * 药物英文名称
     */
    @Column(name = "drug_en_name")
    protected String drugEnName;

    /**
     * 性状
     */
    @Column(name = "characters")
    protected String characters;

    /**
     * 适应症
     */
    @Column(name = "indications")
    protected String indications;

    /**
     * 规格
     */
    @Column(name = "specifications")
    protected String specifications;

    /**
     * 用法
     */
    @Column(name = "usage_method")
    protected String usage;

    /**
     * 不良反应
     */
    @Column(name = "adverse_reactions")
    protected String adverseReactions;

    /**
     * 禁忌
     */
    @Column(name = "taboo")
    protected String taboo;

    /**
     * 注意事项
     */
    @Column(name = "considerations")
    protected String considerations;

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

    public String getDrugClassificationId() {
        return drugClassificationId;
    }

    public void setDrugClassificationId(String drugClassificationId) {
        this.drugClassificationId = drugClassificationId;
    }

    public String getDrugCategoriesId() {
        return drugCategoriesId;
    }

    public void setDrugCategoriesId(String drugCategoriesId) {
        this.drugCategoriesId = drugCategoriesId;
    }

    public String getDrugCategoryId() {
        return drugCategoryId;
    }

    public void setDrugCategoryId(String drugCategoryId) {
        this.drugCategoryId = drugCategoryId;
    }

    public String getWcDrugTypeId() {
        return wcDrugTypeId;
    }

    public void setWcDrugTypeId(String wcDrugTypeId) {
        this.wcDrugTypeId = wcDrugTypeId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugEnName() {
        return drugEnName;
    }

    public void setDrugEnName(String drugEnName) {
        this.drugEnName = drugEnName;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getConsiderations() {
        return considerations;
    }

    public void setConsiderations(String considerations) {
        this.considerations = considerations;
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

