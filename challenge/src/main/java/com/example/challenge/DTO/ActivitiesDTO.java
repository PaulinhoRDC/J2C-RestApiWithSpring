package com.example.challenge.DTO;


import com.example.challenge.Entities.Activity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ActivitiesDTO{

    @JsonProperty("name")
    private String name;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("price")
    private Float price;
    @JsonIgnore
    private String id;

}
