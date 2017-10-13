package org.bank.me.doa;

import org.bank.me.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface OperationsRepository extends JpaRepository<Operation,Long> {
}
