package com.appMain.controllers;

import com.appMain.entity.dto.ClientsDTO;
import com.appMain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientController{
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public @ResponseBody
    ClientsDTO getAllClients(){
        ClientsDTO clientsDTO = new ClientsDTO();
        clientsDTO.setClients(clientService.getAllClients());
        return clientsDTO;

    }
}
