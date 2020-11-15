package com.appMain.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    private final RestTemplate template = new RestTemplate();
    private final String address = "http://client-service:8081/client/";

    @PostMapping
    public ResponseEntity<String> create(@RequestParam String name, @RequestParam int amountOfClient) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("amountOfClient", amountOfClient);

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
    public ResponseEntity<Object> delete(@RequestParam String id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);

        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
}
