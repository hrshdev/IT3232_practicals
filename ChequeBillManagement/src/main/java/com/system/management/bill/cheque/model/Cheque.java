package com.system.management.bill.cheque.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Cheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false)
    private Bill bill;
    
    private String chequeNumber;
    private String bankName;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate issuedDate;
    private boolean isCleared;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}