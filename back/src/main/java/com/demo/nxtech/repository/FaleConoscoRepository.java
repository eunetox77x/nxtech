package com.demo.nxtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.nxtech.entities.FaleConosco;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Integer>{

}
