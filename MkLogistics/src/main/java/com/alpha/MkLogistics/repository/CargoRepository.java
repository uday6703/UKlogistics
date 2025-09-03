package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
