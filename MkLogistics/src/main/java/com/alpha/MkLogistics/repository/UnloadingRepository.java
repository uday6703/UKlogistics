package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Unloading;

@Repository
public interface UnloadingRepository extends JpaRepository<Unloading, Integer> {

}
