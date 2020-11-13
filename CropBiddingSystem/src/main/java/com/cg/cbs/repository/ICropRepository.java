package com.cg.cbs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.cbs.entity.Crop;
import com.cg.cbs.entity.Status;
import com.cg.cbs.exception.FarmerNotFoundException;

@Repository
public interface ICropRepository extends JpaRepository<Crop, Integer> {

	List<Crop> findBycropName(String name);
	
	List<Crop> findBystatus(Status status);
	
	@Query("SELECT c FROM Crop c WHERE farmer_id=?1")
	List<Crop> findCropsByFarmer(int farmerId) throws FarmerNotFoundException;

}
