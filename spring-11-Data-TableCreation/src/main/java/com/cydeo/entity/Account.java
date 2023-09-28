package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass//bir üst sınıfın diğer sınıflar tarafından miras alınmasını ve bu sınıfın alanlarının ve yöntemlerinin kullanılmasını sağlar
                 // @Entity yerine remove ettik bunu yazdik.
                 // ama bu parent class dan tablo olustrmasini istemiyoruz.  ama Bu bilgileri alt classlar kullanbilsin
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}
