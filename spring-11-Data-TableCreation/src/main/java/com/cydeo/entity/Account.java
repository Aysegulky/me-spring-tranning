package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
