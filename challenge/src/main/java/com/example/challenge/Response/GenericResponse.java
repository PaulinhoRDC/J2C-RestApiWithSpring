package com.example.challenge.Response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GenericResponse {
    @Id @GeneratedValue
    @Getter private String id;

}
