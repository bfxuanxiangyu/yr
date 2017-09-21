package com.weeds.entity;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat; 
/**
 * t_district 实体类
 * 由GenEntityMysql类自动生成
 * Fri Jul 15 18:07:50 CST 2016
 * @xuanxy
 */ 
@Entity
@Table(name="t_district")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="area_code")
	private String areaCode;

	@Column(name="area_name")
	private String areaName;

	@Column(name="p_area_code")
	private String pAreaCode;

	@Column(name="remark")
	private String remark;

	@Column(name="sort")
	private Integer sort;


	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id=id;
	}

	public String getAreaCode(){
		return areaCode;
	}

	public void setAreaCode(String areaCode){
		this.areaCode=areaCode;
	}

	public String getAreaName(){
		return areaName;
	}

	public void setAreaName(String areaName){
		this.areaName=areaName;
	}

	public String getpAreaCode(){
		return pAreaCode;
	}

	public void setpAreaCode(String pAreaCode){
		this.pAreaCode=pAreaCode;
	}

	public String getRemark(){
		return remark;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public Integer getSort(){
		return sort;
	}

	public void setSort(Integer sort){
		this.sort=sort;
	}

}

