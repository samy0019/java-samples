package com.packtpub.chapter4.entity;

 

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Property implements Serializable {

@Override
	public String toString() {
		return "Property [key=" + key + ", value=" + value + "]";
	}

@Id
@Column(name="id")
private String key;

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}
  
@Column(name="value")
private String value;

 
}
