package org.bank.me.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.aspectj.apache.bcel.generic.RET;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length = 1)
@JsonTypeInfo(
        use =JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "V", value = Versment.class),
        @JsonSubTypes.Type(name = "R", value = Retrait.class)
}

)
public class Operation implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numerpOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name="CODE_CPTE")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name="CODE_EMP")
    private Employe employe;

    public Operation() {
    }

    public Operation( Date dateOperation, double montant) {
        this.dateOperation = dateOperation;
        this.montant = montant;
    }

    public long getNumerpOperation() {
        return numerpOperation;
    }

    public void setNumerpOperation(long numerpOperation) {
        this.numerpOperation = numerpOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @JsonIgnore
    public Employe getEmploye() {
        return employe;
    }
     @JsonSetter
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
