package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.EExamen;

public interface ExamenRepository extends JpaRepository<EExamen, Integer> {

}
