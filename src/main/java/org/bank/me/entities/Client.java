package org.bank.me.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Client implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeClient;
    private String nomClient;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Compte> comptes;


    public Client() {
    }

    public Client(String nomClient) {
        this.nomClient = nomClient;
    }

    public long getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(long codeClient) {
        this.codeClient = codeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    @JsonIgnore
    public Collection<Compte> getComptes() {
        return comptes;
    }

    @JsonSetter
    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
