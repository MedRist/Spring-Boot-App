package org.bank.me.metier;

import org.bank.me.entities.Employe;

import java.util.List;

public interface EmployeMetier  {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();
}
