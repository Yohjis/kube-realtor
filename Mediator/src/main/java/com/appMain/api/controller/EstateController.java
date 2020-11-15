package com.appMain.api.controller;

import com.appMain.entity.estate.District;
import com.appMain.entity.estate.Estate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "estate")
public class EstateController {
    private final RestTemplate template = new RestTemplate();
    private final String address = "http://estate-service:8083/estate/";

    @PostMapping
    public ResponseEntity<String> create(@RequestParam Estate estate, @RequestParam District district,
                                         @RequestParam double price) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("estate", estate).
                queryParam("district", district).
                queryParam("price", price);
        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping
    public ResponseEntity<String> show() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address);

        HttpEntity<String> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        return ResponseEntity.ok(response.getBody());
    }

    @DeleteMapping
    public void delete(@RequestParam String estateId, @RequestParam String realtorId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("estateId", estateId).
                queryParam("realtorId", realtorId);

        template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
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
        public ResponseEntity<Object> saveEstate(@RequestParam String adress,
            @RequestParam List<Double> array,
            @RequestParam String clientId)
        {
            String decodedId = decodedNumber(clientId);

            Estate estate = (Estate) EstateService.showAddress(
                    EstateService.getEstateListOfRealtor((Realtor) array),
                    decodedId);

            try{
                EstateService.addEstate(estate, adress);
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
