package com.weeds.entity.expert;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * expert 实体类
 * 专家信息[基本信息]
 * Fri Apr 01 18:51:31 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "expert")
public class Expert implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2043965956899664151l;

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
     * 姓名
     */
    @Column(name = "c_name")
    protected String cName;

    /**
     * 账号[手机号码]
     */
    @Column(name = "c_account")
    protected String cAccount;

    /**
     * 密码
     */
    @Column(name = "c_password")
    protected String cPassword;

    /**
     * 科室
     */
    @Column(name = "c_depart_name")
    protected String cDepartName;

    /**
     * 科室ID
     */
    @Column(name = "c_depart_id")
    protected String cDepartId;

    /**
     * 在职医院
     */
    @Column(name = "c_hospital")
    protected String cHospital;

    /**
     * 职称
     */
    @Column(name = "c_professional_title")
    protected String cProfessionalTitle;

    /**
     * 专长
     */
    @Column(name = "c_speciality")
    protected String cSpeciality;

    /**
     * 最高学历
     */
    @Column(name = "c_education")
    protected String cEducation;

    /**
     * 行医年龄
     */
    @Column(name = "c_work_age")
    protected String cWorkAge;

    /**
     * 行医证编号
     */
    @Column(name = "c_workcard_no")
    protected String cWorkcardNo;

    /**
     * 固话号码
     */
    @Column(name = "c_telephone")
    protected String cTelephone;

    /**
     * 手机号码
     */
    @Column(name = "c_mobile")
    protected String cMobile;

    /**
     * 手机号码[在线使用]
     */
    @Column(name = "c_mobile_line")
    protected String cMobileLine;

    /**
     * 电子邮箱
     */
    @Column(name = "c_email")
    protected String cEmail;

    /**
     * 省
     */
    @Column(name = "c_province")
    protected String cProvince;

    /**
     * 省ID
     */
    @Column(name = "c_province_id")
    protected String cProvinceId;

    /**
     * 市
     */
    @Column(name = "c_city")
    protected String cCity;

    /**
     * 市ID
     */
    @Column(name = "c_city_id")
    protected String cCityId;

    /**
     * 区
     */
    @Column(name = "c_district")
    protected String cDistrict;

    /**
     * 区id
     */
    @Column(name = "c_district_id")
    protected String cDistrictId;

    /**
     * 省市区
     */
    @Column(name = "c_province_city")
    protected String cProvinceCity;

    /**
     * 地址
     */
    @Column(name = "c_address")
    protected String cAddress;

    /**
     * 头像
     */
    @Column(name = "c_photo")
    protected String cPhoto;

    /**
     * 手机登陆页图像
     */
    @Column(name = "c_phone_photo")
    protected String cPhonePhoto;

    /**
     * 资格证书-名称【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_qualify_name")
    protected String cQualifyName;

    /**
     * 资格证书-编号【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_qualify_no")
    protected String cQualifyNo;

    /**
     * 资格证书-颁发日期【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_qualify_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cQualifyDate;

    /**
     * 资格证书-图片路径【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_qualify_path")
    protected String cQualifyPath;

    /**
     * 执业证书-名称【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_certificate_name")
    protected String cCertificateName;

    /**
     * 执业证书-编号【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_certificate_no")
    protected String cCertificateNo;

    /**
     * 执业证书-颁发日期【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_certificate_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cCertificateDate;

    /**
     * 执业证书-图片路径【该字段将废弃，统一使用sys_upload_file表】
     */
    @Column(name = "c_certificate_path")
    protected String cCertificatePath;

    /**
     * 职务
     */
    @Column(name = "c_duties")
    protected String cDuties;

    /**
     * QQ
     */
    @Column(name = "c_qq")
    protected String cQq;

    /**
     * 附件路径
     */
    @Column(name = "c_path")
    protected String cPath;

    /**
     * 邮编
     */
    @Column(name = "c_postal_code")
    protected String cPostalCode;

    /**
     * 审核状态 0：不通过 1：通过
     */
    @Column(name = "c_status")
    protected String cStatus;

    /**
     * 审核不通过原因
     */
    @Column(name = "c_reason")
    protected String cReason;

    /**
     * 医生主页地址
     */
    @Column(name = "c_expert_url")
    protected String cExpertUrl;

    /**
     * 账号状态   0禁用    1启用
     */
    @Column(name = "c_using_status")
    protected String cUsingStatus;

    @Column(name = "c_hint")
    protected Integer cHint;

    /**
     * 推荐人
     */
    @Column(name = "c_tjr")
    protected String cTjr;

    @Column(name = "c_gzs")
    protected String cGzs;

    @Column(name = "c_bank_name")
    protected String cBankName;

    @Column(name = "c_bank_account")
    protected String cBankAccount;
    
    @Column(name = "c_bank")
    protected String cBank;

    @Column(name = "C_QRCODE_PATH")
    protected String cQrcodePath;
    
    /**
     * 手机背景状态 0不启动   1启用
     */
    @Column(name = "C_PHONE_BACKGROUND_STATUS")
    protected String cPhoneBackgroundStatus;
    
    @Transient
    protected String goPage;

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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcAccount() {
        return cAccount;
    }

    public void setcAccount(String cAccount) {
        this.cAccount = cAccount;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getcDepartName() {
        return cDepartName;
    }

    public void setcDepartName(String cDepartName) {
        this.cDepartName = cDepartName;
    }

    public String getcDepartId() {
        return cDepartId;
    }

    public void setcDepartId(String cDepartId) {
        this.cDepartId = cDepartId;
    }

    public String getcHospital() {
        return cHospital;
    }

    public void setcHospital(String cHospital) {
        this.cHospital = cHospital;
    }

    public String getcProfessionalTitle() {
        return cProfessionalTitle;
    }

    public void setcProfessionalTitle(String cProfessionalTitle) {
        this.cProfessionalTitle = cProfessionalTitle;
    }

    public String getcSpeciality() {
        return cSpeciality;
    }

    public void setcSpeciality(String cSpeciality) {
        this.cSpeciality = cSpeciality;
    }

    public String getcEducation() {
        return cEducation;
    }

    public void setcEducation(String cEducation) {
        this.cEducation = cEducation;
    }

    public String getcWorkAge() {
        return cWorkAge;
    }

    public void setcWorkAge(String cWorkAge) {
        this.cWorkAge = cWorkAge;
    }

    public String getcWorkcardNo() {
        return cWorkcardNo;
    }

    public void setcWorkcardNo(String cWorkcardNo) {
        this.cWorkcardNo = cWorkcardNo;
    }

    public String getcTelephone() {
        return cTelephone;
    }

    public void setcTelephone(String cTelephone) {
        this.cTelephone = cTelephone;
    }

    public String getcMobile() {
        return cMobile;
    }

    public void setcMobile(String cMobile) {
        this.cMobile = cMobile;
    }

    public String getcMobileLine() {
        return cMobileLine;
    }

    public void setcMobileLine(String cMobileLine) {
        this.cMobileLine = cMobileLine;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince;
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId;
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId;
    }

    public String getcProvinceCity() {
        return cProvinceCity;
    }

    public void setcProvinceCity(String cProvinceCity) {
        this.cProvinceCity = cProvinceCity;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto;
    }

    public String getcPhonePhoto() {
        return cPhonePhoto;
    }

    public void setcPhonePhoto(String cPhonePhoto) {
        this.cPhonePhoto = cPhonePhoto;
    }

    public String getcQualifyName() {
        return cQualifyName;
    }

    public void setcQualifyName(String cQualifyName) {
        this.cQualifyName = cQualifyName;
    }

    public String getcQualifyNo() {
        return cQualifyNo;
    }

    public void setcQualifyNo(String cQualifyNo) {
        this.cQualifyNo = cQualifyNo;
    }

    public Date getcQualifyDate() {
        return cQualifyDate;
    }

    public void setcQualifyDate(Date cQualifyDate) {
        this.cQualifyDate = cQualifyDate;
    }

    public String getcQualifyPath() {
        return cQualifyPath;
    }

    public void setcQualifyPath(String cQualifyPath) {
        this.cQualifyPath = cQualifyPath;
    }

    public String getcCertificateName() {
        return cCertificateName;
    }

    public void setcCertificateName(String cCertificateName) {
        this.cCertificateName = cCertificateName;
    }

    public String getcCertificateNo() {
        return cCertificateNo;
    }

    public void setcCertificateNo(String cCertificateNo) {
        this.cCertificateNo = cCertificateNo;
    }

    public Date getcCertificateDate() {
        return cCertificateDate;
    }

    public void setcCertificateDate(Date cCertificateDate) {
        this.cCertificateDate = cCertificateDate;
    }

    public String getcCertificatePath() {
        return cCertificatePath;
    }

    public void setcCertificatePath(String cCertificatePath) {
        this.cCertificatePath = cCertificatePath;
    }

    public String getcDuties() {
        return cDuties;
    }

    public void setcDuties(String cDuties) {
        this.cDuties = cDuties;
    }

    public String getcQq() {
        return cQq;
    }

    public void setcQq(String cQq) {
        this.cQq = cQq;
    }

    public String getcPath() {
        return cPath;
    }

    public void setcPath(String cPath) {
        this.cPath = cPath;
    }

    public String getcPostalCode() {
        return cPostalCode;
    }

    public void setcPostalCode(String cPostalCode) {
        this.cPostalCode = cPostalCode;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getcReason() {
        return cReason;
    }

    public void setcReason(String cReason) {
        this.cReason = cReason;
    }

    public String getcExpertUrl() {
        return cExpertUrl;
    }

    public void setcExpertUrl(String cExpertUrl) {
        this.cExpertUrl = cExpertUrl;
    }

    public String getcUsingStatus() {
        return cUsingStatus;
    }

    public void setcUsingStatus(String cUsingStatus) {
        this.cUsingStatus = cUsingStatus;
    }

    public Integer getcHint() {
        return cHint;
    }

    public void setcHint(Integer cHint) {
        this.cHint = cHint;
    }

    public String getcTjr() {
        return cTjr;
    }

    public void setcTjr(String cTjr) {
        this.cTjr = cTjr;
    }

    public String getcGzs() {
        return cGzs;
    }

    public void setcGzs(String cGzs) {
        this.cGzs = cGzs;
    }

    public String getcBankName() {
        return cBankName;
    }

    public void setcBankName(String cBankName) {
        this.cBankName = cBankName;
    }

    public String getcBankAccount() {
        return cBankAccount;
    }

    public void setcBankAccount(String cBankAccount) {
        this.cBankAccount = cBankAccount;
    }

    public String getcBank() {
        return cBank;
    }

    public void setcBank(String cBank) {
        this.cBank = cBank;
    }

	public String getcQrcodePath() {
		return cQrcodePath;
	}

	public void setcQrcodePath(String cQrcodePath) {
		this.cQrcodePath = cQrcodePath;
	}

	public String getGoPage() {
		return goPage;
	}

	public void setGoPage(String goPage) {
		this.goPage = goPage;
	}

	public String getcPhoneBackgroundStatus() {
		return cPhoneBackgroundStatus;
	}

	public void setcPhoneBackgroundStatus(String cPhoneBackgroundStatus) {
		this.cPhoneBackgroundStatus = cPhoneBackgroundStatus;
	}


}

