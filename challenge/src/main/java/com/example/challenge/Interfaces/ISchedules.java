package com.example.challenge.Interfaces;
import com.example.challenge.Entities.Scheduling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ISchedules extends CrudRepository<Scheduling, String> {
    Scheduling findAllById(String id);
    ArrayList<Scheduling> findAllBycustomerID(String id);
    void deleteById (String id);
}
