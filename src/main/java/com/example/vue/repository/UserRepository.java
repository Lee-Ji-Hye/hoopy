package com.example.vue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vue.model.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
	Optional<UserEntity> findByUserId(String username);
	int countBySocialToken(String socialToken);
}
