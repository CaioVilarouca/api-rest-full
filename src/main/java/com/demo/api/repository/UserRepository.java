package com.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.api.domain.User;

@Repository // Marca uma interface como acesso a dados
public interface UserRepository extends JpaRepository<User, Integer>{

}