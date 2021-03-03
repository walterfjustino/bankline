package com.bankline.bankline.data.enums;
import java.util.Arrays;

import com.bankline.bankline.data.exception.ObjectNotFoundException;

import lombok.Getter;

@Getter
public enum RoleEnum {
	
	CLIENTE(0, "CLIENTE");	
	
	private RoleEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private int id;
	private String name;
	
	public String getRoleName() {
		return "ROLE_"  + this.name;
	}
	
	public static RoleEnum fromId(int id) {
		return Arrays
				.stream(RoleEnum.values())
				.filter(v -> v.getId() == id)
				.findFirst()
				.orElseThrow(() -> new ObjectNotFoundException("Role de id " + id + " não encontrado"));
	}
	
	
}

