package com.example.challenge.DTO;

import com.example.challenge.Entities.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomersDTO {

    @JsonProperty("first_name")
    private String firstname;
    @JsonProperty("last_name")
    private String lastname;
    @JsonProperty("birthdate")
    private String birthdate;
    @JsonProperty("fiscal_number")
    private long fiscalNumber;
    @JsonProperty("mobile_number")
    private String mobile_number;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private String id;

    public CustomersDTO(String firstName, String lastName){
        this.firstname = firstName;
        this.lastname = lastName;
    }
}
