package com.example;

import lombok.Data;
import java.util.Date;

@Data
public class CompteRequest {
    private double solde;
    private String dateCreation;
    private TypeCompte type;
}

