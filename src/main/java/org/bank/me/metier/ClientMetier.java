package org.bank.me.metier;

import org.bank.me.entities.Client;

import java.util.List;

public interface ClientMetier {
    public Client saveClient(Client client);
    public List<Client> listClient();
}
