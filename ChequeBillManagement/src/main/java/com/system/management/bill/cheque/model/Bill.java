package com.system.management.bill.cheque.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "distributor_id", nullable = false)
    private Distributor distributor;
    
    private LocalDate productReceivedDate;
    private BigDecimal latestBillAmount;
    private BigDecimal totalAmount;
    private LocalDate expectedChequeDate;
    private boolean isSettled;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Cheque> cheques;
}