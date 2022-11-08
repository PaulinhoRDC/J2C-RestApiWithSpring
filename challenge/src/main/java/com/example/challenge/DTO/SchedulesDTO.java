package com.example.challenge.DTO;

import com.example.challenge.Entities.Scheduling;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulesDTO {
    @JsonProperty("description")
    private String description;
    @JsonProperty("date")
    private String date;
    @JsonProperty("customer_id")
    private String customerID;
    @JsonProperty("activity_id")
    private String activityID;
    @JsonIgnore
    private String id;

}
