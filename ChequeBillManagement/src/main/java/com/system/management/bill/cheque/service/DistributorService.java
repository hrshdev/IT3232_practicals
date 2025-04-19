package com.system.management.bill.cheque.service;

import com.system.management.bill.cheque.model.Distributor;
import com.system.management.bill.cheque.repository.DistributorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistributorService {
    private final DistributorRepository distributorRepository;
    
    public Distributor createDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }
    
    public List<Distributor> getAllDistributors() {
        return distributorRepository.findAll();
    }
    
    public Optional<Distributor> getDistributorById(Long id) {
        return distributorRepository.findById(id);
    }
    
    public List<Distributor> searchDistributors(String name) {
        return distributorRepository.findByNameContainingIgnoreCase(name);
    }
}