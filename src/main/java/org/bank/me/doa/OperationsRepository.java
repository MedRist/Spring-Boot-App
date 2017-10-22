package org.bank.me.doa;

import org.bank.me.entities.Compte;
import org.bank.me.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.*;

public interface OperationsRepository extends JpaRepository<Operation,Long> {
    @Query("select o from Operation o where o.compte.codeCompte =:x")
    public Page<Operation> getOperation(@Param("x") String code, Pageable page);

    public Page<Operation> findByCompte(Compte cp, Pageable pageable);
}
