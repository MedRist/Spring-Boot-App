package org.bank.me.metier;

import org.bank.me.entities.Compte;

public interface CompteMetier {

    public Compte saveCompte(Compte  c);
    public Compte getCompte(String code);
}
