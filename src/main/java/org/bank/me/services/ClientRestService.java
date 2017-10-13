package org.bank.me.services;

import org.bank.me.entities.Client;
import org.bank.me.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestService  {
    @Autowired
    private ClientMetier clientMetier;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public Client saveClient(@RequestBody Client client) {
        return clientMetier.saveClient(client);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> listClient() {
        return clientMetier.listClient();
    }



}
