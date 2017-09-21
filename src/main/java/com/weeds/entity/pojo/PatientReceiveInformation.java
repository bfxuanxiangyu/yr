package com.weeds.entity.pojo;

import com.weeds.entity.patient.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * patient_receive_information 实体类
 * 患者订单邮递信息
 * Fri Apr 01 18:51:34 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "patient_receive_information")
public class PatientReceiveInformation {

    /**
     * 主键ID
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
     * 患者预约ID
     */
    @Column(name = "c_appoint_order")
    protected String cAppointOrder;

    /**
     * 患者ID
     */
    @Column(name = "c_patient_id")
    protected String cPatientId;

    /**
     * 邮寄名字
     */
    @Column(name = "c_name")
    protected String cName;

    /**
     * 邮寄电话
     */
    @Column(name = "c_mobile")
    protected String cMobile;

    /**
     * 邮寄邮箱
     */
    @Column(name = "c_post_code")
    protected String cPostCode;

    /**
     * 邮寄地址
     */
    @Column(name = "c_address")
    protected String cAddress;

    /**
     * 0:未发送 1： 已发送
     */
    @Column(name = "c_status")
    protected Integer cStatus;
    
    
    @Transient
    protected Patient patient;
    
    @Transient
    protected String cOrderNo;


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

    public String getcAppointOrder() {
        return cAppointOrder;
    }

    public void setcAppointOrder(String cAppointOrder) {
        this.cAppointOrder = cAppointOrder;
    }

    public String getcPatientId() {
        return cPatientId;
    }

    public void setcPatientId(String cPatientId) {
        this.cPatientId = cPatientId;
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

    public String getcPostCode() {
        return cPostCode;
    }

    public void setcPostCode(String cPostCode) {
        this.cPostCode = cPostCode;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getcOrderNo() {
		return cOrderNo;
	}

	public void setcOrderNo(String cOrderNo) {
		this.cOrderNo = cOrderNo;
	}

}

