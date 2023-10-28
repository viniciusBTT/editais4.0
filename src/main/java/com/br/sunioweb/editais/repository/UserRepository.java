/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.sunioweb.editais.repository;

import com.br.sunioweb.editais.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vinicius
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByUsername(@Param("username") String username);
    
}
