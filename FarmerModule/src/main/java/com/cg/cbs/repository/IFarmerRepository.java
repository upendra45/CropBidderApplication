package com.cg.cbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cbs.entity.Farmer;
import com.cg.cbs.exception.FarmerNotFoundException;

public interface IFarmerRepository extends JpaRepository<Farmer ,Integer>{

}

