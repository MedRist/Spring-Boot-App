package org.bank.me.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeEmploye;
    private String nomEmploye;
    @ManyToOne
    @JoinColumn(name = "code_emp_sup")
    private Employe employeSup;

    @ManyToMany
    @JoinColumn(name = "EMP_GR")
    private Collection<Groupe> groupes;


    public Employe() {
    }

    public Employe(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public long getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(long codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    @JsonIgnore
    public String getNomEmploye() {
        return nomEmploye;
    }

    @JsonSetter
    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public Employe getEmployeSup() {
        return employeSup;
    }

    public void setEmployeSup(Employe employeSup) {
        this.employeSup = employeSup;
    }

    @JsonIgnore
    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }
}
