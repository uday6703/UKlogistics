package com.alpha.MkLogistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.MkLogistics.entities.Loading;

@Repository
public interface LoadingRepository extends JpaRepository<Loading, Integer> {

}
