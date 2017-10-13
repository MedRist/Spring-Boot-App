package org.bank.me.services;

import org.bank.me.doa.CompteRepository;
import org.bank.me.entities.Compte;
import org.bank.me.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteRestService {
    @Autowired
    private CompteMetier compteMetier;

    @RequestMapping(value = "/comptes", method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte c) {
        return compteMetier.saveCompte(c);
    }
    @RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String code) {
        return compteMetier.getCompte(code);
    }




}
