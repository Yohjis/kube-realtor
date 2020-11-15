package com.appMain.repo;

import com.appMain.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DealRepository extends  JpaRepository<Deal, UUID>{

}