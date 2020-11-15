package com.appMain.service;

import com.appMain.entity.dto.EstateDTO;
import com.appMain.repo.ClientRepository;
import com.appMain.repo.DealRepository;
import com.appMain.repo.EstateRepository;
import com.appMain.entity.dto.Client;
import com.appMain.entity.Deal;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class DealService {
    private static final String REALTOR_URL = "http://realtorservice:8082";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();
    private final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    private final EstateRepository estateRepository;
    private final DealRepository dealRepository;
    private final ClientRepository clientRepository;


    @Autowired
    public DealService(EstateRepository estateRepository, DealRepository dealRepository, ClientRepository clientRepository) {
        this.estateRepository = estateRepository;
        this.dealRepository = dealRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    @Transactional
    public boolean addDeal(Realtor realtor, List<Estate> address, Client client) {
        List<Estate> toDeal = new ArrayList<>();
        for (Estate e : address) {
            if (client.getCash() < e.getPrice()) {
                System.out.println("Client(" + client.getFirstName() + " " + client.getLastName()
                        + ") price which can spend is " + e.getPrice() + ". \n Them can't reserve " + e.getAddress());
            } else {
                Estate estate = estateRepository.findEstateByAddress(e.getAddress());
                if (estate == null) {
                    continue;
                }
                if (toDeal.size() > 0) {
                    Deal deal = new Deal(estate, client, realtor);
                    System.out.println("New deal has created: " + deal);
                    clientRepository.save(client);
                    dealRepository.save(deal);
                } else {
                    System.out.println("There is no " + e.getAddress() + ". It has been sold already.");
                    estateRepository.delete(estate);
                }
            }
        }
        return false;
    }

    private boolean createDeal(List<EstateDTO> estatesToDeal, Realtor realtor, Client client) {
        boolean flag = false;
        UUID id = UUID.randomUUID();
        double price = estatesToDeal.stream().mapToDouble(EstateDTO::getPrice).sum();
        Deal deal = new Deal(id, realtor, client.getClientId(), price);
        for (EstateDTO e : estatesToDeal) {
            Estate estate = new Estate();
            deal.setId(deal.getId());
            estate.setId(e.getEstateId());
            System.out.println("New deal has created: " + deal);
            dealRepository.save(deal);
            estateRepository.save(estate);
            flag = true;
        }
        return flag;
    }

    private EstateDTO getEstateFromServiceByAddress(String estateAddress) {
        ResponseEntity<EstateDTO> response = restTemplate
                .exchange(REALTOR_URL + "/estates/address=" + estateAddress,
                        HttpMethod.GET, headersEntity, EstateDTO.class);
        return response.getBody();
    }
}