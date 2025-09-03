package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
