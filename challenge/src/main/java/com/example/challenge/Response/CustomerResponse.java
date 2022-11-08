package com.example.challenge.Response;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerResponse {

    @Id @GeneratedValue
    @Getter private String id;
    @Getter @Setter private String first_name;
    @Getter @Setter private String last_name;
    @Getter @Setter private String birthdate;
    @Getter @Setter private long fiscal_number;
    @Getter @Setter private String mobile_number;
}
