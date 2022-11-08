package com.example.challenge.Entities;

import lombok.*;

import javax.persistence.*;

@Table(name="scheduling")
@Entity
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Scheduling {
    @Id @GeneratedValue
    @Getter private String id;
    @Getter @Setter private String description;
    @Getter @Setter private String date;
    @Column(name="customer_id")
    @Getter @Setter private String customerID;
    @Column(name="activity_id")
    @Getter @Setter private String activityID;

}
