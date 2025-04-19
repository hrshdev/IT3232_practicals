package com.system.management.bill.cheque.repository;

import com.system.management.bill.cheque.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByDistributorId(Long distributorId);
    List<Bill> findByIsSettled(boolean isSettled);
    List<Bill> findByExpectedChequeDateBetween(LocalDate start, LocalDate end);
}