package org.bank.me.metier;


import org.bank.me.doa.CompteRepository;
import org.bank.me.doa.EmployeRepository;
import org.bank.me.doa.OperationsRepository;
import org.bank.me.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OperationMetierImp implements OperationMetier {

    @Autowired
    private OperationsRepository operationsRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    @Transactional
    public boolean verser(String code, double montant, Long codeEmp) {
        Compte compte = compteRepository.findOne(code);
        Operation o =new Versment();
        Employe employe = employeRepository.findOne(codeEmp);
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setEmploye(employe);
        o.setCompte(compte);
        operationsRepository.save(o);
        compte.setSolde(compte.getSolde()+montant);

        return true;
    }

    @Override
    @Transactional
    public boolean retirer(String code, double montant, Long codeEmp) {
        Compte compte = compteRepository.findOne(code);
        if (compte.getSolde() < montant) throw new RuntimeException("Solde insuffisant");
        Operation o =new Retrait();
        Employe employe = employeRepository.findOne(codeEmp);
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(compte);
        o.setEmploye(employe);
        operationsRepository.save(o);
        compte.setSolde(compte.getSolde()- montant);
        return true;    }

    @Override
    @Transactional
    public boolean virement(String code1, String code2, double montant, Long codeEmp) {
        retirer(code1,montant,codeEmp);
        verser(code2,montant,codeEmp);
        return true;
    }

    @Override
    public PageOperations getOperation(String codeCompte, int page, int size) {
        Page<Operation> ops =operationsRepository.getOperation(codeCompte,new PageRequest(page, size));
        PageOperations pop =new PageOperations();
        pop.setOperations(ops.getContent());
        pop.setNombre_Operations(ops.getNumberOfElements());
        pop.setPage(ops.getNumber());
        pop.setTotal_page(ops.getTotalPages());
        pop.setNombre_Operations((int) ops.getTotalElements());
        return pop;
    }
}
