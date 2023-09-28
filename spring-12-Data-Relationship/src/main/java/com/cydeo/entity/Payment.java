package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) //OneToOne==>payment in paymentDetail ile one to one iliskisi olur.
                                                                // Burada payments tablosunda payment_detail_id gorunur.
                                                                // Ayni islem paymentDetailde de olusturuldugunda birbirlerinin
                                                                // tablosunda gorunurler
                                                                // Payment PARENT iken PaymentDEtail CHILD dir.
                                                                // *whenever we save,delete a payment' spring boot is gonna go to payment detail table and he's gonna save,delete the payment detail as well automatically for you.
                                                                // (Ne zaman bir ödeme kaydetsek,silersek, Spring Boot ödeme detay tablosuna gidecek ve ödeme detayını da sizin için otomatik olarak kaydedecektir,silecektir.)
    @JoinColumn(name = "payment_detail_id")//payment_detail_id tablosu ile iliskili oldugunu gosterir. //

    private PaymentDetail paymentDetail;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
