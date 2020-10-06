package com.cg.obs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.obs.dto.User;


public interface UserRepository extends JpaRepository<User,Integer>
{
  
}
