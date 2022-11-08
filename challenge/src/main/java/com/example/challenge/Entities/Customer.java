package com.example.challenge.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table (name="customer")
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Customer {
    @Id @GeneratedValue                                 //@Id @GeneratedValue(strategy = GenerationType.AUTO)     //Gerar automaticamente id
    @Getter private String id;                          // @Getter private UUID id;                                //String
    @Column(name="first_name")
    @Getter @Setter private String firstname;
    @Column(name="last_name")
    @Getter @Setter private String lastname;
    @Getter @Setter private String birthdate;
    @Column(name="fiscal_number")
    @Getter @Setter private long fiscalNumber;
    @Getter @Setter private String mobile_number;
    @Getter @Setter private String email;

    public Customer (String firstname, String lastnamem,String birthdate,long fiscalNumber, String mobile_number, String email){
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastnamem;
        this.birthdate = birthdate;
        this.fiscalNumber = fiscalNumber;
        this.mobile_number = mobile_number;
        this.email = email;
    }
}
