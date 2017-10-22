package org.bank.me.services;


import org.bank.me.metier.OperationMetier;
import org.bank.me.metier.PageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperationRestService {

    @Autowired
    private OperationMetier operationMetier;

    @RequestMapping(value = "/versement", method = RequestMethod.PUT)
    public boolean verser(@RequestParam String code,
                          @RequestParam double montant,
                          @RequestParam Long codeEmp) {
        return operationMetier.verser(code, montant, codeEmp);
    }

    @RequestMapping(value = "/retrait", method = RequestMethod.PUT)
    public boolean retirer(@RequestParam String code,
                           @RequestParam double montant,
                           @RequestParam Long codeEmp) {
        return operationMetier.retirer(code, montant, codeEmp);
    }

    @RequestMapping(value = "/virement", method = RequestMethod.PUT)
    public boolean virement(@RequestParam String code1,
                            @RequestParam String code2,
                            @RequestParam double montant,
                            @RequestParam Long codeEmp) {
        return operationMetier.virement(code1, code2, montant, codeEmp);
    }
    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public PageOperations getOperation(@RequestParam String codeCompte,
                                    @RequestParam int page,
                                    @RequestParam int size) {
        return operationMetier.getOperation(codeCompte, page, size);
    }


}
