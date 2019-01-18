package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.EPais;
@Repository
public interface PaisRepository extends JpaRepository<EPais,Integer> {

}
