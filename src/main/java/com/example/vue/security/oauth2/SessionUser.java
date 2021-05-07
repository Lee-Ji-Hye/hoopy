package com.example.vue.security.oauth2;

import java.io.Serializable;

import com.example.vue.model.UserEntity;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{
	private String userId;
	private String name;
	private String socialToken;
	private String type;
	
	public SessionUser(UserEntity userEntity) {
		this.userId = userEntity.getUserId();
		this.name = userEntity.getName();
		this.socialToken = userEntity.getSocialToken();
		this.type = userEntity.getType();
	}
}

