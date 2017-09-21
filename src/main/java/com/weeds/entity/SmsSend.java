package com.weeds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sms_send 实体类
 * Fri Apr 01 18:51:34 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "sms_send")
public class SmsSend {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 目标手机号码
     */
    @Column(name = "mobile")
    protected String mobile;

    /**
     * 短信内容
     */
    @Column(name = "content")
    protected String content;

    /**
     * 该短信有效秒数
     */
    @Column(name = "expired_seconds")
    protected Integer expiredSeconds;

    /**
     * 发送者
     */
    @Column(name = "create_by")
    protected String createBy;

    /**
     * 发送时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    protected Date createTime;

    /**
     * 发送结果，1-成功，0-失败
     */
    @Column(name = "success")
    protected Integer success;

    /**
     * 短信当中的关键词
     */
    @Column(name = "keywords")
    protected String keywords;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getExpiredSeconds() {
        return expiredSeconds;
    }

    public void setExpiredSeconds(Integer expiredSeconds) {
        this.expiredSeconds = expiredSeconds;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

}

