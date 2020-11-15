package com.appMain.repo;

import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RealtorRepository extends JpaRepository<Realtor, UUID> {

}
