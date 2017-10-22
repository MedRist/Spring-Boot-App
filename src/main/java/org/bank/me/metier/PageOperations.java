package org.bank.me.metier;

import org.bank.me.entities.Operation;

import java.io.Serializable;
import java.util.List;

public class PageOperations implements Serializable{

    private List<Operation> operations;
    private int page;
    private int nombre_Operations;
    private int total_page;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNombre_Operations() {
        return nombre_Operations;
    }

    public void setNombre_Operations(int nombre_Operations) {
        this.nombre_Operations = nombre_Operations;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }
}
