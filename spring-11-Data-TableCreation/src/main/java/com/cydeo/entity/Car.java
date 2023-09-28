package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor//Car sinifinin icinde otomatik olarak parametresiz
                  // bir kurucu methodu olusturur. Bu method sayesinde
                  //ise car sinifinin nesnelerini parametresiz olarak
                  // olusturmamizi saglar.Boylece parametresiz kurucu
                  // metodu her defasinda elle yazmak yerine Lombok
                  // tarafindan otomatik uretilmis bir sinif olarak kullanilabilir.
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //JpaRepository<Car,Long>   ==> Buradali LONG id ye yapilan Long tanimlamasindan kaynaklanir. Integer' String vb de olabilirdi
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}