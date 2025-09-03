package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Carrier;


@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer> {
	Carrier findByName(String name);
}
