package com.pos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pos.entities.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long>{
	public Optional<UserEntity> findOneByNickname(String nickname);
}
