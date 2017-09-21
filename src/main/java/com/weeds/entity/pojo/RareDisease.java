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
 * rare_disease 实体类
 * 罕见病
 * 由GenEntityMysql类自动生成
 * Fri Jul 01 08:34:11 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "rare_disease")
public class RareDisease implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 分类id
     */
    @Column(name = "classification_id")
    protected String classificationId;

    /**
     * 中文名称
     */
    @Column(name = "name_cn")
    protected String nameCn;

    /**
     * 英文名称
     */
    @Column(name = "name_en")
    protected String nameEn;

    /**
     * 别名
     */
    @Column(name = "alias")
    protected String alias;

    /**
     * 患病概率
     */
    @Column(name = "sick_probability")
    protected String sickProbability;

    /**
     * 遗传方式
     */
    @Column(name = "inheritance_mode")
    protected String inheritanceMode;

    /**
     * ICD编码
     */
    @Column(name = "icd_code")
    protected String icdCode;

    /**
     * 描述
     */
    @Column(name = "description")
    protected String description;

    /**
     * 概述
     */
    @Column(name = "summary")
    protected String summary;

    /**
     * 病因
     */
    @Column(name = "cause")
    protected String cause;

    /**
     * 发病机制
     */
    @Column(name = "nosogenesis")
    protected String nosogenesis;

    /**
     * 症状表现
     */
    @Column(name = "symptom")
    protected String symptom;

    /**
     * 检查
     */
    @Column(name = "scan")
    protected String scan;

    /**
     * 鉴别
     */
    @Column(name = "identify")
    protected String identify;

    /**
     * 诊断
     */
    @Column(name = "diagnose")
    protected String diagnose;

    /**
     * 并发症
     */
    @Column(name = "complication")
    protected String complication;

    /**
     * 治疗
     */
    @Column(name = "treat")
    protected String treat;

    /**
     * 替代治疗
     */
    @Column(name = "replacement_therapy")
    protected String replacementTherapy;

    /**
     * 其他治疗
     */
    @Column(name = "other_therapy")
    protected String otherTherapy;

    /**
     * 预防和筛检
     */
    @Column(name = "prevention")
    protected String prevention;

    /**
     * 来源
     */
    @Column(name = "source")
    protected String source;

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(String classificationId) {
        this.classificationId = classificationId;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSickProbability() {
        return sickProbability;
    }

    public void setSickProbability(String sickProbability) {
        this.sickProbability = sickProbability;
    }

    public String getInheritanceMode() {
        return inheritanceMode;
    }

    public void setInheritanceMode(String inheritanceMode) {
        this.inheritanceMode = inheritanceMode;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getNosogenesis() {
        return nosogenesis;
    }

    public void setNosogenesis(String nosogenesis) {
        this.nosogenesis = nosogenesis;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getComplication() {
        return complication;
    }

    public void setComplication(String complication) {
        this.complication = complication;
    }

    public String getTreat() {
        return treat;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    public String getReplacementTherapy() {
        return replacementTherapy;
    }

    public void setReplacementTherapy(String replacementTherapy) {
        this.replacementTherapy = replacementTherapy;
    }

    public String getOtherTherapy() {
        return otherTherapy;
    }

    public void setOtherTherapy(String otherTherapy) {
        this.otherTherapy = otherTherapy;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

}

