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
 * patient_appoint_condition 实体类
 * 预约病情，每次预约时记录的病情。
 * Fri Apr 01 18:51:33 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "patient_appoint_condition")
public class PatientAppointCondition {

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
     * 患者ID
     */
    @Column(name = "c_patients_id")
    protected String cPatientsId;

    /**
     * 医生ID
     */
    @Column(name = "c_expert_id")
    protected String cExpertId;

    /**
     * 哮喘总病程
     */
    @Column(name = "c_dyspnea_date")
    protected String cDyspneaDate;

    /**
     * 治疗
     */
    @Column(name = "c_treat")
    protected String cTreat;

    /**
     * 末次发作至今
     */
    @Column(name = "c_last")
    protected String cLast;

    /**
     * 近两周来喘息
     */
    @Column(name = "c_pant")
    protected String cPant;

    /**
     * 程度
     */
    @Column(name = "c_pant_degree")
    protected String cPantDegree;

    /**
     * 咳嗽‘无’选项
     */
    @Column(name = "c_cough_wu")
    protected String cCoughWu;

    /**
     * 咳嗽年月
     */
    @Column(name = "c_cough_date")
    protected String cCoughDate;

    /**
     * 咳嗽时段
     */
    @Column(name = "c_cough_period")
    protected String cCoughPeriod;

    /**
     * 咳嗽时段其他
     */
    @Column(name = "c_cough_period2")
    protected String cCoughPeriod2;

    /**
     * 咳嗽有无痰
     */
    @Column(name = "c_cough_phlegm_status")
    protected String cCoughPhlegmStatus;

    /**
     * 咳嗽痰颜色
     */
    @Column(name = "c_cough_phlegm")
    protected String cCoughPhlegm;

    /**
     * 鼻部症状
     */
    @Column(name = "c_nose")
    protected String cNose;

    /**
     * 鼻 '无'选项
     */
    @Column(name = "c_nose_wu")
    protected String cNoseWu;

    /**
     * 鼻部程度
     */
    @Column(name = "c_nose_degree")
    protected String cNoseDegree;

    /**
     * 持续时间
     */
    @Column(name = "c_nose_time")
    protected String cNoseTime;

    /**
     * 鼻部年月
     */
    @Column(name = "c_nose_date")
    protected String cNoseDate;

    /**
     * 眼部
     */
    @Column(name = "c_eye")
    protected String cEye;

    /**
     * 眼部持续时间
     */
    @Column(name = "c_eye_time")
    protected String cEyeTime;

    /**
     * 眼部年月
     */
    @Column(name = "c_eye_date")
    protected String cEyeDate;

    /**
     * 眼部其他
     */
    @Column(name = "c_eye_other")
    protected String cEyeOther;

    /**
     * 有无发热
     */
    @Column(name = "c_fever")
    protected String cFever;

    /**
     * 有无剧烈运动
     */
    @Column(name = "c_strenuous_sport")
    protected String cStrenuousSport;

    /**
     * 有无接触过敏原
     */
    @Column(name = "c_touch_allergen")
    protected String cTouchAllergen;

    /**
     * 如果有，过敏原是
     */
    @Column(name = "c_allergen")
    protected String cAllergen;

    /**
     * 是否运动受限
     */
    @Column(name = "c_sport")
    protected String cSport;

    /**
     * 是否用过速效β受体激动剂
     */
    @Column(name = "c_agonist")
    protected String cAgonist;

    /**
     * 如果是
     */
    @Column(name = "c_if_is")
    protected String cIfIs;

    /**
     * PEF
     */
    @Column(name = "c_pef")
    protected String cPef;

    /**
     * FEV1
     */
    @Column(name = "c_fev1")
    protected String cFev1;

    /**
     * 呼出气一氧化氮
     */
    @Column(name = "c_yhdjc")
    protected String cYhdjc;

    /**
     * c_ACT
     */
    @Column(name = "c_c_act")
    protected String cCAct;

    /**
     * 主诉内容
     */
    @Column(name = "c_complaint")
    protected String cComplaint;

    /**
     * 病情补充描述
     */
    @Column(name = "c_desc")
    protected String cDesc;

    /**
     * 舒利迭
     */
    @Column(name = "c_advair")
    protected String cAdvair;

    /**
     * 次/月
     */
    @Column(name = "c_advair_count")
    protected String cAdvairCount;

    /**
     * 共几月
     */
    @Column(name = "c_advair_month")
    protected String cAdvairMonth;

    /**
     * 辅舒酮
     */
    @Column(name = "c_flixotide")
    protected String cFlixotide;

    /**
     * 次/月
     */
    @Column(name = "c_flixotide_count")
    protected String cFlixotideCount;

    /**
     * 共几月
     */
    @Column(name = "c_flixotide_month")
    protected String cFlixotideMonth;

    /**
     * 信必可
     */
    @Column(name = "c_symbicort")
    protected String cSymbicort;

    /**
     * 次/月
     */
    @Column(name = "c_symbicort_count")
    protected String cSymbicortCount;

    /**
     * 共几月
     */
    @Column(name = "c_symbicort_month")
    protected String cSymbicortMonth;

    /**
     * 顺尔宁
     */
    @Column(name = "c_singulair")
    protected String cSingulair;

    /**
     * 次/月
     */
    @Column(name = "c_singulair_count")
    protected String cSingulairCount;

    /**
     * 共几月
     */
    @Column(name = "c_singulair_month")
    protected String cSingulairMonth;

    /**
     * 开瑞坦
     */
    @Column(name = "c_claritin")
    protected String cClaritin;

    /**
     * 次/月
     */
    @Column(name = "c_claritin_count")
    protected String cClaritinCount;

    /**
     * 共几月
     */
    @Column(name = "c_claritin_month")
    protected String cClaritinMonth;

    /**
     * 普米克今舒
     */
    @Column(name = "c_pulmicort")
    protected String cPulmicort;

    /**
     * 次/月
     */
    @Column(name = "c_pulmicort_count")
    protected String cPulmicortCount;

    /**
     * 共几月
     */
    @Column(name = "c_pulmicort_month")
    protected String cPulmicortMonth;

    /**
     * 其他用药
     */
    @Column(name = "c_medicine_other")
    protected String cMedicineOther;

    /**
     * 医生建议
     */
    @Column(name = "c_expert_advise")
    protected String cExpertAdvise;


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

    public String getcPatientsId() {
        return cPatientsId;
    }

    public void setcPatientsId(String cPatientsId) {
        this.cPatientsId = cPatientsId;
    }

    public String getcExpertId() {
        return cExpertId;
    }

    public void setcExpertId(String cExpertId) {
        this.cExpertId = cExpertId;
    }

    public String getcDyspneaDate() {
        return cDyspneaDate;
    }

    public void setcDyspneaDate(String cDyspneaDate) {
        this.cDyspneaDate = cDyspneaDate;
    }

    public String getcTreat() {
        return cTreat;
    }

    public void setcTreat(String cTreat) {
        this.cTreat = cTreat;
    }

    public String getcLast() {
        return cLast;
    }

    public void setcLast(String cLast) {
        this.cLast = cLast;
    }

    public String getcPant() {
        return cPant;
    }

    public void setcPant(String cPant) {
        this.cPant = cPant;
    }

    public String getcPantDegree() {
        return cPantDegree;
    }

    public void setcPantDegree(String cPantDegree) {
        this.cPantDegree = cPantDegree;
    }

    public String getcCoughWu() {
        return cCoughWu;
    }

    public void setcCoughWu(String cCoughWu) {
        this.cCoughWu = cCoughWu;
    }

    public String getcCoughDate() {
        return cCoughDate;
    }

    public void setcCoughDate(String cCoughDate) {
        this.cCoughDate = cCoughDate;
    }

    public String getcCoughPeriod() {
        return cCoughPeriod;
    }

    public void setcCoughPeriod(String cCoughPeriod) {
        this.cCoughPeriod = cCoughPeriod;
    }

    public String getcCoughPeriod2() {
        return cCoughPeriod2;
    }

    public void setcCoughPeriod2(String cCoughPeriod2) {
        this.cCoughPeriod2 = cCoughPeriod2;
    }

    public String getcCoughPhlegmStatus() {
        return cCoughPhlegmStatus;
    }

    public void setcCoughPhlegmStatus(String cCoughPhlegmStatus) {
        this.cCoughPhlegmStatus = cCoughPhlegmStatus;
    }

    public String getcCoughPhlegm() {
        return cCoughPhlegm;
    }

    public void setcCoughPhlegm(String cCoughPhlegm) {
        this.cCoughPhlegm = cCoughPhlegm;
    }

    public String getcNose() {
        return cNose;
    }

    public void setcNose(String cNose) {
        this.cNose = cNose;
    }

    public String getcNoseWu() {
        return cNoseWu;
    }

    public void setcNoseWu(String cNoseWu) {
        this.cNoseWu = cNoseWu;
    }

    public String getcNoseDegree() {
        return cNoseDegree;
    }

    public void setcNoseDegree(String cNoseDegree) {
        this.cNoseDegree = cNoseDegree;
    }

    public String getcNoseTime() {
        return cNoseTime;
    }

    public void setcNoseTime(String cNoseTime) {
        this.cNoseTime = cNoseTime;
    }

    public String getcNoseDate() {
        return cNoseDate;
    }

    public void setcNoseDate(String cNoseDate) {
        this.cNoseDate = cNoseDate;
    }

    public String getcEye() {
        return cEye;
    }

    public void setcEye(String cEye) {
        this.cEye = cEye;
    }

    public String getcEyeTime() {
        return cEyeTime;
    }

    public void setcEyeTime(String cEyeTime) {
        this.cEyeTime = cEyeTime;
    }

    public String getcEyeDate() {
        return cEyeDate;
    }

    public void setcEyeDate(String cEyeDate) {
        this.cEyeDate = cEyeDate;
    }

    public String getcEyeOther() {
        return cEyeOther;
    }

    public void setcEyeOther(String cEyeOther) {
        this.cEyeOther = cEyeOther;
    }

    public String getcFever() {
        return cFever;
    }

    public void setcFever(String cFever) {
        this.cFever = cFever;
    }

    public String getcStrenuousSport() {
        return cStrenuousSport;
    }

    public void setcStrenuousSport(String cStrenuousSport) {
        this.cStrenuousSport = cStrenuousSport;
    }

    public String getcTouchAllergen() {
        return cTouchAllergen;
    }

    public void setcTouchAllergen(String cTouchAllergen) {
        this.cTouchAllergen = cTouchAllergen;
    }

    public String getcAllergen() {
        return cAllergen;
    }

    public void setcAllergen(String cAllergen) {
        this.cAllergen = cAllergen;
    }

    public String getcSport() {
        return cSport;
    }

    public void setcSport(String cSport) {
        this.cSport = cSport;
    }

    public String getcAgonist() {
        return cAgonist;
    }

    public void setcAgonist(String cAgonist) {
        this.cAgonist = cAgonist;
    }

    public String getcIfIs() {
        return cIfIs;
    }

    public void setcIfIs(String cIfIs) {
        this.cIfIs = cIfIs;
    }

    public String getcPef() {
        return cPef;
    }

    public void setcPef(String cPef) {
        this.cPef = cPef;
    }

    public String getcFev1() {
        return cFev1;
    }

    public void setcFev1(String cFev1) {
        this.cFev1 = cFev1;
    }

    public String getcYhdjc() {
        return cYhdjc;
    }

    public void setcYhdjc(String cYhdjc) {
        this.cYhdjc = cYhdjc;
    }

    public String getcCAct() {
        return cCAct;
    }

    public void setcCAct(String cCAct) {
        this.cCAct = cCAct;
    }

    public String getcComplaint() {
        return cComplaint;
    }

    public void setcComplaint(String cComplaint) {
        this.cComplaint = cComplaint;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }

    public String getcAdvair() {
        return cAdvair;
    }

    public void setcAdvair(String cAdvair) {
        this.cAdvair = cAdvair;
    }

    public String getcAdvairCount() {
        return cAdvairCount;
    }

    public void setcAdvairCount(String cAdvairCount) {
        this.cAdvairCount = cAdvairCount;
    }

    public String getcAdvairMonth() {
        return cAdvairMonth;
    }

    public void setcAdvairMonth(String cAdvairMonth) {
        this.cAdvairMonth = cAdvairMonth;
    }

    public String getcFlixotide() {
        return cFlixotide;
    }

    public void setcFlixotide(String cFlixotide) {
        this.cFlixotide = cFlixotide;
    }

    public String getcFlixotideCount() {
        return cFlixotideCount;
    }

    public void setcFlixotideCount(String cFlixotideCount) {
        this.cFlixotideCount = cFlixotideCount;
    }

    public String getcFlixotideMonth() {
        return cFlixotideMonth;
    }

    public void setcFlixotideMonth(String cFlixotideMonth) {
        this.cFlixotideMonth = cFlixotideMonth;
    }

    public String getcSymbicort() {
        return cSymbicort;
    }

    public void setcSymbicort(String cSymbicort) {
        this.cSymbicort = cSymbicort;
    }

    public String getcSymbicortCount() {
        return cSymbicortCount;
    }

    public void setcSymbicortCount(String cSymbicortCount) {
        this.cSymbicortCount = cSymbicortCount;
    }

    public String getcSymbicortMonth() {
        return cSymbicortMonth;
    }

    public void setcSymbicortMonth(String cSymbicortMonth) {
        this.cSymbicortMonth = cSymbicortMonth;
    }

    public String getcSingulair() {
        return cSingulair;
    }

    public void setcSingulair(String cSingulair) {
        this.cSingulair = cSingulair;
    }

    public String getcSingulairCount() {
        return cSingulairCount;
    }

    public void setcSingulairCount(String cSingulairCount) {
        this.cSingulairCount = cSingulairCount;
    }

    public String getcSingulairMonth() {
        return cSingulairMonth;
    }

    public void setcSingulairMonth(String cSingulairMonth) {
        this.cSingulairMonth = cSingulairMonth;
    }

    public String getcClaritin() {
        return cClaritin;
    }

    public void setcClaritin(String cClaritin) {
        this.cClaritin = cClaritin;
    }

    public String getcClaritinCount() {
        return cClaritinCount;
    }

    public void setcClaritinCount(String cClaritinCount) {
        this.cClaritinCount = cClaritinCount;
    }

    public String getcClaritinMonth() {
        return cClaritinMonth;
    }

    public void setcClaritinMonth(String cClaritinMonth) {
        this.cClaritinMonth = cClaritinMonth;
    }

    public String getcPulmicort() {
        return cPulmicort;
    }

    public void setcPulmicort(String cPulmicort) {
        this.cPulmicort = cPulmicort;
    }

    public String getcPulmicortCount() {
        return cPulmicortCount;
    }

    public void setcPulmicortCount(String cPulmicortCount) {
        this.cPulmicortCount = cPulmicortCount;
    }

    public String getcPulmicortMonth() {
        return cPulmicortMonth;
    }

    public void setcPulmicortMonth(String cPulmicortMonth) {
        this.cPulmicortMonth = cPulmicortMonth;
    }

    public String getcMedicineOther() {
        return cMedicineOther;
    }

    public void setcMedicineOther(String cMedicineOther) {
        this.cMedicineOther = cMedicineOther;
    }

    public String getcExpertAdvise() {
        return cExpertAdvise;
    }

    public void setcExpertAdvise(String cExpertAdvise) {
        this.cExpertAdvise = cExpertAdvise;
    }

}

