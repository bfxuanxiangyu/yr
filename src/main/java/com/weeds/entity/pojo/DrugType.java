package com.weeds.entity.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * drug_type 实体类
 * 中西药分类
 * 由GenEntityMysql类自动生成
 * Sat Jul 16 15:41:58 CST 2016
 *
 * @ZhangBing
 */
@Entity
@Table(name = "drug_type")
public class DrugType implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    protected String id;

    /**
     * 中西药分类名称
     */
    @Column(name = "wc_drug_type")
    protected String wcDrugType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWcDrugType() {
        return wcDrugType;
    }

    public void setWcDrugType(String wcDrugType) {
        this.wcDrugType = wcDrugType;
    }

}

