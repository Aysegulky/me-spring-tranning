package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity //sınıfın veritabanında kalıcı olarak saklanması gerektiğini işaretler.
@Table(name = "students")//Table annotation'ı ile "Student" sınıfının "student" adlı bir veritabanı tablosuna karşılık geldiği belirtilmiştir.
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id alanına bir değer atamamıza gerek yoktur.
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")//JPA'ya "birtDate" alaninin  "DATE" sutunu ile eslemesini soyler.Stun basliginin ne oldugunun animlanmasi ile ilgili
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)
//    @Enumerated(EnumType.ORDINAL)
    private Gender gender;


    @Transient
    private String city;


}
