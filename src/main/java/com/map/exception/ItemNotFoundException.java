package com.map.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemNotFoundException extends RuntimeException{


	String resourceName;
	
	String fieldName;
	
	long fieldValue;

	String filedValueString;
	
	public ItemNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName, fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	public ItemNotFoundException(String resourceName, String fieldName, String filedValueString) {
		super(String.format("%s not found with %s : %s",resourceName, fieldName,filedValueString));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.filedValueString = filedValueString;
	}
	
}
