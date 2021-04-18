package com.lapitus.mysbdemo.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lapitus.mysbdemo.entities.Client;
import com.lapitus.mysbdemo.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class ClientController {

    private final static Logger logger = LoggerFactory.getLogger(ClientController.class);
    ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping("/json")
    public String json() {
        String resultMsg = "All records saved";
        //get json data from resource
        URL url = this.getClass().getClassLoader().getResource("people.json");
        if (url != null) {
            File jsonFile = new File(url.getFile());

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Client> clientList = objectMapper.readValue(jsonFile, new TypeReference<List<Client>>() {
                });
                clientRepository.saveAll(clientList);
            } catch (IOException e) {
                e.printStackTrace();
                resultMsg = "Error while inserting clients";
                logger.error(resultMsg);
            }
            logger.info(resultMsg);

        } else {
            resultMsg = "Can't insert clients, URL is NULL";
            logger.warn(resultMsg);
        }

        return resultMsg;
    }
}

