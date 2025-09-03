package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	Driver findByContact(long contact);
}
