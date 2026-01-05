package com.example;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long compteId;
    private double montant;
    private String date;
    private TypeTransaction type;
}

