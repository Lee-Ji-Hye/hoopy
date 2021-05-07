package com.example.vue.security.oauth2;

import java.util.Map;

import com.example.vue.model.UserEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	
	private String userId;
	private String name;
	private String socialToken;
	private String type;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String userId, String name, String socialToken, String type) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.userId = userId;
		this.name = name;
		this.socialToken = socialToken;
		this.type = type;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return ofGoogle(registrationId, userNameAttributeName, attributes);
	}
	
	private static OAuthAttributes ofGoogle(String registrationId, String userNameAttibuteName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.attributes(attributes)
				.nameAttributeKey(userNameAttibuteName)
				.type(registrationId)
				.userId((String) attributes.get("email"))
				.name((String) attributes.get("name"))
				.socialToken((String) attributes.get("sub"))
				.build();
	}
	
	public UserEntity toEntity() {
		return UserEntity.builder()
				.userId(userId)
				.name(name)
				.socialToken(socialToken)
				.type(type)
				.build();
	}
}
