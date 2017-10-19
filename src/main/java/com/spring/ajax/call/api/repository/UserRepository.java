package com.spring.ajax.call.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.ajax.call.api.dto.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
