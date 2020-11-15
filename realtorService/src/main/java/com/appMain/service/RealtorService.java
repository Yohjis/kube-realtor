package com.appMain.service;

import com.appMain.repo.RealtorRepository;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RealtorService {

    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository) {
        this.realtorRepository = realtorRepository;
    }

    @Transactional
    public void addEstateInAddress(Realtor realtor, String address){
        realtorRepository.save(realtor);}


    @Transactional
    public void saveRealtorEstate(Realtor realtor){
        realtorRepository.save(realtor);
    }

    @Transactional
    public void addRealtor(Realtor realtor){
            realtorRepository.save(realtor);
        }

    /* @Transactional(readOnly = true)
    public List<Realtor> getRealtorList() { return RealtorRepository.getRealtorList(); }
    public void addRealtor(Realtor realtor){ getRealtorList().add(realtor); }
    public void removeRealtor(Realtor realtor){
        if(getRealtorList().isEmpty());
        throw new RuntimeException("Not found");
    }*/
}
