package com.weeds.entity.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * patient_appoint_order_cancel 实体类
 * 预约订单取消表
 * Fri Apr 01 18:51:33 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "patient_appoint_order_cancel")
public class PatientAppointOrderCancel {

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
     * 预约订单ID
     */
    @Column(name = "c_order_id")
    protected String cOrderId;

    /**
     * 取消人的角色：0-患者，1-医生
     */
    @Column(name = "c_role")
    protected Integer cRole;

    /**
     * 取消原因
     */
    @Column(name = "c_reason")
    protected String cReason;

    /**
     * 备注
     */
    @Column(name = "c_note")
    protected String cNote;


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

    public String getcOrderId() {
        return cOrderId;
    }

    public void setcOrderId(String cOrderId) {
        this.cOrderId = cOrderId;
    }

    public Integer getcRole() {
        return cRole;
    }

    public void setcRole(Integer cRole) {
        this.cRole = cRole;
    }

    public String getcReason() {
        return cReason;
    }

    public void setcReason(String cReason) {
        this.cReason = cReason;
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote;
    }

}

