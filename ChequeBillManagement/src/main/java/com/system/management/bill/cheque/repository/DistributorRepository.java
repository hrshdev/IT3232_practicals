package com.system.management.bill.cheque.repository;

import com.system.management.bill.cheque.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    List<Distributor> findByNameContainingIgnoreCase(String name);
}