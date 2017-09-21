package com.weeds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * sms_template 实体类
 * Fri Apr 01 18:51:34 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "sms_template")
public class SmsTemplate {

    /**
     * 模板名称
     */
    @Id
    @Column(name = "template_name")
    protected String templateName;

    /**
     * 内容
     */
    @Column(name = "content")
    protected String content;


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

