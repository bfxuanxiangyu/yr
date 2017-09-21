package com.weeds.entity.patient;

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
 * patient 实体类
 * 患者管理信息
 * Sat Apr 02 12:14:02 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

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
     * 姓名
     */
    @Column(name = "c_name")
    protected String cName;

    /**
     * 手机号码
     */
    @Column(name = "c_mobile")
    protected String cMobile;

    /**
     * 密码
     */
    @Column(name = "c_password")
    protected String cPassword;

    /**
     * 电子邮箱
     */
    @Column(name = "c_email")
    protected String cEmail;

    /**
     * 身份证
     */
    @Column(name = "c_id_card")
    protected String cIdCard;

    /**
     * 出生年月
     */
    @Column(name = "c_birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date cBirthdate;

    /**
     * 国籍
     */
    @Column(name = "c_nationality")
    protected String cNationality;

    /**
     * 民族
     */
    @Column(name = "c_nation")
    protected String cNation;

    /**
     * 籍贯
     */
    @Column(name = "c_native_place")
    protected String cNativePlace;

    /**
     * 省
     */
    @Column(name = "c_province")
    protected String cProvince;

    @Column(name = "c_jprovince")
    protected String cJprovince;

    /**
     * 省ID
     */
    @Column(name = "c_province_id")
    protected String cProvinceId;

    @Column(name = "c_jprovince_id")
    protected String cJprovinceId;

    /**
     * 市
     */
    @Column(name = "c_city")
    protected String cCity;

    @Column(name = "c_jcity")
    protected String cJcity;

    /**
     * 市ID
     */
    @Column(name = "c_city_id")
    protected String cCityId;

    @Column(name = "c_jcity_id")
    protected String cJcityId;

    /**
     * 区
     */
    @Column(name = "c_district")
    protected String cDistrict;

    @Column(name = "c_jdistrict")
    protected String cJdistrict;

    /**
     * 区ID
     */
    @Column(name = "c_district_id")
    protected String cDistrictId;

    @Column(name = "c_jdistrict_id")
    protected String cJdistrictId;

    /**
     * 省市区
     */
    @Column(name = "c_province_city")
    protected String cProvinceCity;

    @Column(name = "c_jprovince_city")
    protected String cJprovinceCity;

    /**
     * 地址
     */
    @Column(name = "c_address")
    protected String cAddress;

    /**
     * 邮编
     */
    @Column(name = "c_post_code")
    protected String cPostCode;

    /**
     * 患者头像
     */
    @Column(name = "c_photo")
    protected String cPhoto;

    /**
     * 电话
     */
    @Column(name = "c_tel")
    protected String cTel;

    /**
     * 性别
     */
    @Column(name = "c_sex")
    protected String cSex;

    /**
     * 咨询手机
     */
    @Column(name = "c_mobile_line")
    protected String cMobileLine;

    /**
     * QQ
     */
    @Column(name = "c_qq")
    protected String cQq;

    /**
     * 医生主页网址
     */
    @Column(name = "c_expert_url")
    protected String cExpertUrl;

    /**
     * 监护人姓名
     */
    @Column(name = "c_guardian")
    protected String cGuardian;

    /**
     * 与患者关系
     */
    @Column(name = "c_relationship")
    protected String cRelationship;


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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcMobile() {
        return cMobile;
    }

    public void setcMobile(String cMobile) {
        this.cMobile = cMobile;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcIdCard() {
        return cIdCard;
    }

    public void setcIdCard(String cIdCard) {
        this.cIdCard = cIdCard;
    }

    public Date getcBirthdate() {
        return cBirthdate;
    }

    public void setcBirthdate(Date cBirthdate) {
        this.cBirthdate = cBirthdate;
    }

    public String getcNationality() {
        return cNationality;
    }

    public void setcNationality(String cNationality) {
        this.cNationality = cNationality;
    }

    public String getcNation() {
        return cNation;
    }

    public void setcNation(String cNation) {
        this.cNation = cNation;
    }

    public String getcNativePlace() {
        return cNativePlace;
    }

    public void setcNativePlace(String cNativePlace) {
        this.cNativePlace = cNativePlace;
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince;
    }

    public String getcJprovince() {
        return cJprovince;
    }

    public void setcJprovince(String cJprovince) {
        this.cJprovince = cJprovince;
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId;
    }

    public String getcJprovinceId() {
        return cJprovinceId;
    }

    public void setcJprovinceId(String cJprovinceId) {
        this.cJprovinceId = cJprovinceId;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcJcity() {
        return cJcity;
    }

    public void setcJcity(String cJcity) {
        this.cJcity = cJcity;
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId;
    }

    public String getcJcityId() {
        return cJcityId;
    }

    public void setcJcityId(String cJcityId) {
        this.cJcityId = cJcityId;
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    public String getcJdistrict() {
        return cJdistrict;
    }

    public void setcJdistrict(String cJdistrict) {
        this.cJdistrict = cJdistrict;
    }

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId;
    }

    public String getcJdistrictId() {
        return cJdistrictId;
    }

    public void setcJdistrictId(String cJdistrictId) {
        this.cJdistrictId = cJdistrictId;
    }

    public String getcProvinceCity() {
        return cProvinceCity;
    }

    public void setcProvinceCity(String cProvinceCity) {
        this.cProvinceCity = cProvinceCity;
    }

    public String getcJprovinceCity() {
        return cJprovinceCity;
    }

    public void setcJprovinceCity(String cJprovinceCity) {
        this.cJprovinceCity = cJprovinceCity;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcPostCode() {
        return cPostCode;
    }

    public void setcPostCode(String cPostCode) {
        this.cPostCode = cPostCode;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex;
    }

    public String getcMobileLine() {
        return cMobileLine;
    }

    public void setcMobileLine(String cMobileLine) {
        this.cMobileLine = cMobileLine;
    }

    public String getcQq() {
        return cQq;
    }

    public void setcQq(String cQq) {
        this.cQq = cQq;
    }

    public String getcExpertUrl() {
        return cExpertUrl;
    }

    public void setcExpertUrl(String cExpertUrl) {
        this.cExpertUrl = cExpertUrl;
    }

    public String getcGuardian() {
        return cGuardian;
    }

    public void setcGuardian(String cGuardian) {
        this.cGuardian = cGuardian;
    }

    public String getcRelationship() {
        return cRelationship;
    }

    public void setcRelationship(String cRelationship) {
        this.cRelationship = cRelationship;
    }

}

