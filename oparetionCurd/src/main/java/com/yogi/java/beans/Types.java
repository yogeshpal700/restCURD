package com.yogi.java.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "types")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })//very impotent
@XmlRootElement
public class Types {
	
	@Id
	@GeneratedValue
	@Column
	private int typeId;
	@Column
	private String type;
	@Column
	private int tex;
	
	public Types() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Types(int typeId, String type, int tex) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.tex = tex;
	}



	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTex() {
		return tex;
	}
	public void setTex(int tex) {
		this.tex = tex;
	}
	
	

}
