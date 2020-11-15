package com.estateservice.repo;

import com.estateservice.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EstateRepository extends JpaRepository<Estate, UUID>{

    @Query("SELECT e FROM Estate e WHERE e.address = :address")
    Estate findEstateByAddress(@Param("address") String address);
}