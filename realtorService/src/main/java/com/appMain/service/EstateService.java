package com.appMain.service;

import com.appMain.repo.EstateRepository;
import com.appMain.entity.Estate;
import com.appMain.entity.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class EstateService {
    private final EstateRepository estateRepository;
    private final List<Estate> activeEstateList;
    private final List<Estate> passiveEstateList;
    private final List<Estate> requiredEstate;

    @Autowired
    public EstateService(EstateRepository estateRepository) {
        this.estateRepository = estateRepository;
        activeEstateList = new ArrayList<>();
        passiveEstateList = new ArrayList<>();
        requiredEstate = new ArrayList<>();
    }
    @Transactional
    public List getAllActiveEstate(){return activeEstateList;}
    public List<Estate> getActiveEstateList(String decodedId) {return activeEstateList; }
    List<Estate> getPassiveEstateList() {return passiveEstateList;}
    List<Estate> getRequiredEstate() { return  requiredEstate;}
    public List showAddress(List<Estate> estateListOfRealtor, String decodedId) {return showAddress();}

    public void deleteEstate(Estate estate) {
        if(activeEstateList.contains(estate)) {
            activeEstateList.remove(estate);
            return;
        }

        if(passiveEstateList.contains(estate)) {
            passiveEstateList.remove(estate);
            return; 
        }

        throw new RuntimeException("Not found");
    }

    public void setInactiveEstate(Estate estate) {
        if(activeEstateList.contains(estate)){
            passiveEstateList.add(estate);
            activeEstateList.remove(estate);
        }else throw new RuntimeException("Estate is not found");
    }

    public void clearEstateLists(){
        activeEstateList.clear();
        passiveEstateList.clear();
    }

    public void deleteEstate(String estateAddress, String decodedNumber) {
        passiveEstateList.clear();
    }

    public List<Estate> getByPrice(double priceLow, double priceHigh) {
        List<Estate> estatesByPrice = new ArrayList<>();
        activeEstateList.stream()
                .filter(estate -> {
                    final Double price = estate.getPrice();
                    if(price > priceLow && price < priceHigh)
                        return true;
                    else return false;
                }).forEach(estate -> estatesByPrice.add(estate));
        return estatesByPrice;
    }


    public List<Estate> getEstateListOfRealtor(Realtor realtor) {
        List<Estate> estatesOfRealtor = new ArrayList<>();

        activeEstateList
                .stream()
                .filter(estate -> (estate.getRealtor().equals(realtor)))
                .forEach(estate -> estatesOfRealtor.add(estate));

        return estatesOfRealtor;
    }
    public List<Estate> showAddress() {
        List<Estate> activeEstateList = new ArrayList<>();
        activeEstateList
                .stream()
                .filter(estate -> (estate.getAddress().equals(1)))
                .forEach(estate -> activeEstateList.add(estate));
        return activeEstateList;
    }

    @Transactional
    public void addEstate(Estate estate, String address){
        if(estateRepository.findEstateByAddress(estate.getAddress()) == null){
            estateRepository.save(estate);
        }
    }

    @Transactional
    public Estate findEstateByAddress(String address){
        return estateRepository.findEstateByAddress(address);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#############################################");
        stringBuilder.append("\nEstates: ");
        for(Estate e: activeEstateList){
            stringBuilder.append("\nid: ").append(e.getId()).append("\t address: ")
                    .append(e.getAddress()).append("\n price: ").append(e.getPrice());
        }
        stringBuilder.append("\n\n#############################################");

        return stringBuilder.toString();
    }


}
