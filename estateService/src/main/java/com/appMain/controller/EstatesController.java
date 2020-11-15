package com.estateservice.controller;

import com.estateservice.entity.dto.EstatesDTO;
import com.estateservice.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estates")
public class EstatesController {
    private final EstateService estateService;

    @Autowired
    public EstatesController(EstateService estateService) {
        this.estateService = estateService;
    }

    @GetMapping
    public @ResponseBody EstatesDTO getAllActiveEstates(){
        EstatesDTO estatesDTO = new EstatesDTO();
        estatesDTO.setEstates(estateService.getAllActiveEstate());
        return estatesDTO;
    }

}


/*

@RestController
@RequestMapping(value = "/estates", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstatesController<EstateDTO> {
    private final EstateService EstateService;

    @Autowired
    public EstatesController(EstateService estateService) {
        this.EstateService = estateService;
    }

    private String decodedNumber(String number)
    {
        return number.replace("%252B","+");
    }
    @RequestMapping(value = "/getActiveEstates")
    public @ResponseBody EstateDTO getActiveEstate() throws IOException {
        EstatesDTO estateDTO = new EstatesDTO();
        assert showEstates() != null;
        return (EstateDTO) estateDTO;
    }

    private Estate showEstates() {
        return null;
    }

    @GetMapping("/show")
    public ResponseEntity<List<Estate>> showEstates(@RequestParam String id)
    {
        String decodedId = decodedNumber(id);
        List<Estate> estates = EstateService.getActiveEstateList(decodedId);

        return ResponseEntity.ok(estates);

    }
    @DeleteMapping("/")
    public ResponseEntity<String> deleteFromBase(@RequestParam String EstateAdress,
                                                 @RequestParam String clientId)
    {
        String decodedNumber = decodedNumber(clientId);
        try{
            EstateService.deleteEstate(showEstates());
        }
        catch (Exception e){
            return new ResponseEntity<>("Bad request: "+e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Successfully deleted estate '"+ EstateAdress +"'",
                HttpStatus.OK);
        }
        @PostMapping("/save")
        public ResponseEntity<Object> saveEstate(@RequestParam String address,
            @RequestParam List<Double> array,
            @RequestParam String clientId)
        {
            String decodedId = decodedNumber(clientId);

            Estate estate = (Estate) EstateService.showAddress(
                    EstateService.getEstateListOfRealtor((Realtor) array),
                    decodedId);

            try{
                EstateService.addEstate(estate, address);
            }
            catch (IllegalArgumentException e){
                return new ResponseEntity<>("Bad request: "
                        + e.getMessage(),HttpStatus.BAD_REQUEST);
            }
            return  new ResponseEntity<>("Added",
                    HttpStatus.OK);
        }

    }
*/
