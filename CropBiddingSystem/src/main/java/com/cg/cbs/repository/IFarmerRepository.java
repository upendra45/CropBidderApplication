package com.cg.cbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cbs.entity.Farmer;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {

}
