package com.example.challenge.Entities;

import lombok.*;

import javax.persistence.*;

@Table(name="activity")
@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Activity {
    @Id @GeneratedValue
    @Getter private String id;
    @Column(name="name")
    @Getter @Setter private String name;
    @Column(name="duration")
    @Getter @Setter private String duration;
    @Column(name="price")
    @Getter @Setter private float price;
}
