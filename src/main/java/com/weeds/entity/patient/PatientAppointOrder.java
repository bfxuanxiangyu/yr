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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * patient_appoint_order 实体类
 * 患者预约订单
 * Mon Apr 04 11:56:04 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "patient_appoint_order")
public class PatientAppointOrder implements Serializable {

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
     * 预约订单号
     */
    @Column(name = "c_order_no")
    protected String cOrderNo;

    /**
     * 患者ID
     */
    @Column(name = "c_patient_id")
    protected String cPatientId;

    /**
     * 专家ID
     */
    @Column(name = "c_expert_id")
    protected String cExpertId;

    /**
     * 预约安排的ID，对应expert_appoint_arrange表
     */
    @Column(name = "c_arrange_id")
    protected String cArrangeId;

    /**
     * 预约日期
     */
    @Column(name = "c_appoint_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cAppointDate;

    /**
     * 预约时间段：1-上午，2-下午，3-晚上
     */
    @Column(name = "c_appoint_hour_range")
    protected String cAppointHourRange;

    /**
     * 预约状态：0-等待支付，1-已付款等待医生电话，2-已通话，3-已取消预约
     */
    @Column(name = "c_appoint_status")
    protected Integer cAppointStatus;

    /**
     * 是否加急：0-不加急，1-加急
     */
    @Column(name = "c_is_urgent")
    protected Integer cIsUrgent;

    /**
     * 特殊预约的开始时间
     */
    @Column(name = "c_urgent_date_begin")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cUrgentDateBegin;

    /**
     * 特殊预约的结束时间
     */
    @Column(name = "c_urgent_date_end")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cUrgentDateEnd;

    /**
     * 订单金额
     */
    @Column(name = "c_price")
    protected Double cPrice;

    /**
     * 通话时长（分钟）
     */
    @Column(name = "c_call_duration")
    protected Double cCallDuration;

    /**
     * 预约病情ID
     */
    @Column(name = "c_condition_id")
    protected String cConditionId;

    /**
     * 医生修改预约日期备注
     */
    @Column(name = "c_update_date_note")
    protected String cUpdateDateNote;

    /**
     * 取消预约备注
     */
    @Column(name = "c_update_status_note")
    protected String cUpdateStatusNote;

    /**
     * 取消预约角色，0-患者，1-医生
     */
    @Column(name = "c_cancel_role")
    protected Integer cCancelRole;

    /**
     * 天翼流水号
     */
    @Column(name = "c_easy_pay_no")
    protected String cEasyPayNo;

    /**
     * 银行流水号
     */
    @Column(name = "c_bank_no")
    protected String cBankNo;

    /**
     * 支付时间
     */
    @Column(name = "c_paysuccess_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date cPaysuccessDate;

    /**
     * 医生建议
     */
    @Column(name = "c_doctor_advice")
    protected String cDoctorAdvice;

    /**
     * 监护人姓名
     */
    @Column(name = "c_guardian_name")
    protected String cGuardianName;

    /**
     * 监护人地址
     */
    @Column(name = "c_guardian_address")
    protected String cGuardianAddress;

    /**
     * 监护人手机
     */
    @Column(name = "c_guardian_mobile")
    protected String cGuardianMobile;

    /**
     * 患者依从性id
     */
    @Column(name = "c_patient_evaluation_id")
    protected String cPatientEvaluationId;
    
    @Transient
    protected Expert expert;
    
    @Transient
    protected Patient patient;


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

    public String getcOrderNo() {
        return cOrderNo;
    }

    public void setcOrderNo(String cOrderNo) {
        this.cOrderNo = cOrderNo;
    }

    public String getcPatientId() {
        return cPatientId;
    }

    public void setcPatientId(String cPatientId) {
        this.cPatientId = cPatientId;
    }

    public String getcExpertId() {
        return cExpertId;
    }

    public void setcExpertId(String cExpertId) {
        this.cExpertId = cExpertId;
    }

    public String getcArrangeId() {
        return cArrangeId;
    }

    public void setcArrangeId(String cArrangeId) {
        this.cArrangeId = cArrangeId;
    }

    public Date getcAppointDate() {
        return cAppointDate;
    }

    public void setcAppointDate(Date cAppointDate) {
        this.cAppointDate = cAppointDate;
    }

    public String getcAppointHourRange() {
        return cAppointHourRange;
    }

    public void setcAppointHourRange(String cAppointHourRange) {
        this.cAppointHourRange = cAppointHourRange;
    }

    public Integer getcAppointStatus() {
        return cAppointStatus;
    }

    public void setcAppointStatus(Integer cAppointStatus) {
        this.cAppointStatus = cAppointStatus;
    }

    public Integer getcIsUrgent() {
        return cIsUrgent;
    }

    public void setcIsUrgent(Integer cIsUrgent) {
        this.cIsUrgent = cIsUrgent;
    }

    public Date getcUrgentDateBegin() {
        return cUrgentDateBegin;
    }

    public void setcUrgentDateBegin(Date cUrgentDateBegin) {
        this.cUrgentDateBegin = cUrgentDateBegin;
    }

    public Date getcUrgentDateEnd() {
        return cUrgentDateEnd;
    }

    public void setcUrgentDateEnd(Date cUrgentDateEnd) {
        this.cUrgentDateEnd = cUrgentDateEnd;
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public Double getcCallDuration() {
        return cCallDuration;
    }

    public void setcCallDuration(Double cCallDuration) {
        this.cCallDuration = cCallDuration;
    }

    public String getcConditionId() {
        return cConditionId;
    }

    public void setcConditionId(String cConditionId) {
        this.cConditionId = cConditionId;
    }

    public String getcUpdateDateNote() {
        return cUpdateDateNote;
    }

    public void setcUpdateDateNote(String cUpdateDateNote) {
        this.cUpdateDateNote = cUpdateDateNote;
    }

    public String getcUpdateStatusNote() {
        return cUpdateStatusNote;
    }

    public void setcUpdateStatusNote(String cUpdateStatusNote) {
        this.cUpdateStatusNote = cUpdateStatusNote;
    }

    public Integer getcCancelRole() {
        return cCancelRole;
    }

    public void setcCancelRole(Integer cCancelRole) {
        this.cCancelRole = cCancelRole;
    }

    public String getcEasyPayNo() {
        return cEasyPayNo;
    }

    public void setcEasyPayNo(String cEasyPayNo) {
        this.cEasyPayNo = cEasyPayNo;
    }

    public String getcBankNo() {
        return cBankNo;
    }

    public void setcBankNo(String cBankNo) {
        this.cBankNo = cBankNo;
    }

    public Date getcPaysuccessDate() {
        return cPaysuccessDate;
    }

    public void setcPaysuccessDate(Date cPaysuccessDate) {
        this.cPaysuccessDate = cPaysuccessDate;
    }

    public String getcDoctorAdvice() {
        return cDoctorAdvice;
    }

    public void setcDoctorAdvice(String cDoctorAdvice) {
        this.cDoctorAdvice = cDoctorAdvice;
    }

    public String getcGuardianName() {
        return cGuardianName;
    }

    public void setcGuardianName(String cGuardianName) {
        this.cGuardianName = cGuardianName;
    }

    public String getcGuardianAddress() {
        return cGuardianAddress;
    }

    public void setcGuardianAddress(String cGuardianAddress) {
        this.cGuardianAddress = cGuardianAddress;
    }

    public String getcGuardianMobile() {
        return cGuardianMobile;
    }

    public void setcGuardianMobile(String cGuardianMobile) {
        this.cGuardianMobile = cGuardianMobile;
    }

    public String getcPatientEvaluationId() {
        return cPatientEvaluationId;
    }

    public void setcPatientEvaluationId(String cPatientEvaluationId) {
        this.cPatientEvaluationId = cPatientEvaluationId;
    }

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}

