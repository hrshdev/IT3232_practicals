package com.system.management.bill.cheque.service;

import com.system.management.bill.cheque.model.Bill;
import com.system.management.bill.cheque.model.Cheque;
import com.system.management.bill.cheque.repository.BillRepository;
import com.system.management.bill.cheque.repository.ChequeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChequeService {
    private final ChequeRepository chequeRepository;
    private final BillRepository billRepository;
    
    public Cheque createCheque(Cheque cheque, Long billId) {
        Bill bill = billRepository.findById(billId)
            .orElseThrow(() -> new RuntimeException("Bill not found"));
        
        cheque.setBill(bill);
        
        BigDecimal totalPaid = bill.getCheques().stream()
            .map(Cheque::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .add(cheque.getAmount());
            
        if (totalPaid.compareTo(bill.getTotalAmount()) >= 0) {
            bill.setIsSettled(true);
            billRepository.save(bill);
        }
        
        return chequeRepository.save(cheque);
    }
    
    public List<Cheque> getUpcomingCheques(LocalDate from, LocalDate to) {
        return chequeRepository.findByDueDateBetween(from, to);
    }
    
    public List<Cheque> getPendingCheques() {
        return chequeRepository.findByIsCleared(false);
    }
    
    public Cheque getChequeById(Long id) {
        return chequeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cheque not found"));
    }
    
    public Cheque updateCheque(Cheque cheque) {
        return chequeRepository.save(cheque);
    }
}