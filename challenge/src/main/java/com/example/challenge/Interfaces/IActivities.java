package com.example.challenge.Interfaces;
import com.example.challenge.DTO.ActivitiesDTO;
import com.example.challenge.Entities.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface IActivities extends CrudRepository<Activity, String> {
    Activity findAllById(String id);

    ArrayList<Activity> findAll();

}
