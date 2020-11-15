package com.appMain.controller;

import com.appMain.entity.dto.Client;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import com.appMain.entity.dto.CreateDealDTO;
import com.appMain.entity.dto.DealsDTO;
import com.appMain.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deals")
public class DealController{
    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {

            this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<Void> createDeal(@RequestBody CreateDealDTO createDeal){
        Realtor realtor = createDeal.getRealtor();
        Client client = createDeal.getClient();
        System.out.println(client);
        List<Estate> estate = createDeal.getEstates();
        dealService.addDeal(realtor, estate, client);

        if(dealService.addDeal(realtor, estate, client))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
        }

    @GetMapping
    public @ResponseBody DealsDTO getAllDeals(){
        DealsDTO dealsDTO = new DealsDTO();
        dealsDTO.setDeals(dealService.getAllDeals());
    return dealsDTO;
    }
}
