package org.bank.me.metier;

import org.bank.me.doa.CompteRepository;
import org.bank.me.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompteMetierImpl implements CompteMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Compte saveCompte(Compte c) {
        c.setDateCreation(new Date());
        return compteRepository.save(c);
    }

    @Override
    public Compte getCompte(String code)

    {
        Compte c = compteRepository.findOne(code);
        if (c == null) throw new  RuntimeException("Compte Innexistant !");
        return compteRepository.findOne(code);
    }
}
