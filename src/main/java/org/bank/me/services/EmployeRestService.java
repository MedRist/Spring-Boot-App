package org.bank.me.services;

import org.bank.me.entities.Employe;
import org.bank.me.metier.EmployeMetier;
import org.bank.me.metier.EmployeMetierImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeRestService {
    @Autowired
    private EmployeMetier employeMetier;
    @RequestMapping(value = "/employes", method = RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeMetier.saveEmploye(e);
    }

    @RequestMapping(value = "/employes", method = RequestMethod.GET)
    public List<Employe> listEmployes() {
        return employeMetier.listEmployes();
    }






}
