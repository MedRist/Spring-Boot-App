package org.bank.me.metier;

import org.bank.me.entities.Compte;

public interface OperationMetier {

    public boolean verser (String code, double montant, Long codeEmp);
    public boolean retirer(String code,double montant,Long codeEmp );
    public boolean virement(String code1, String code2, double montant, Long codeEmp);
    public PageOperations getOperation(String codeCompte, int page, int size);

}
