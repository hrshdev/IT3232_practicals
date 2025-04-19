package com.system.management.bill.cheque.repository;

import com.system.management.bill.cheque.model.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ChequeRepository extends JpaRepository<Cheque, Long> {
    List<Cheque> findByBillId(Long billId);
    List<Cheque> findByDueDateBetween(LocalDate start, LocalDate end);
    List<Cheque> findByIsCleared(boolean isCleared);
}