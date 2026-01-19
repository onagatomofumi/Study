package com.example.demoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoSpring.entity.UserEntity;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}