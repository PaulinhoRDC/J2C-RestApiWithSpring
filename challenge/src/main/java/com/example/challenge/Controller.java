package com.example.challenge;
import com.example.challenge.DTO.ActivitiesDTO;
import com.example.challenge.DTO.CustomersDTO;
import com.example.challenge.DTO.SchedulesDTO;
import com.example.challenge.Entities.Scheduling;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;


@RestController
@Slf4j
public class Controller {
    @Autowired
    private MyService servico;

    //Customer
    @GetMapping("customer")
    private CustomersDTO getCustomerById(@RequestHeader String id) throws Exception {
        return this.servico.getCustomerById(id);
    }

    @PostMapping("customer")
    private void addCustomer(@Valid @RequestBody CustomersDTO add) { //Adicionar a resposta!
        this.servico.addCustomer(add);
    }

    @PutMapping("customer")
    private void update(@Valid @RequestBody CustomersDTO customer,@RequestHeader String id) throws Exception {
        this.servico.update(customer,id);
    }

    @PatchMapping(path = "customer", consumes = "application/json-patch+json")
    private void patchCustomer(@RequestBody CustomersDTO customer, @RequestHeader String id) throws Exception {
        this.servico.updatePatch(customer, id);
    }

    @DeleteMapping("customer")
    private void removeCustomer(@RequestHeader String id) throws Exception {
        this.servico.removeCust(id);
    }

    @PostMapping("customer/upload")
    private void upload(@RequestHeader String file) throws Exception {
        this.servico.uploadPhoto(file);
    }

    //Activity
    @GetMapping("activity")
    private ActivitiesDTO getActivityById(@RequestHeader String id) throws Exception {
        return this.servico.getActivityById(id);
    }

    @GetMapping("activities")
    private ArrayList<ActivitiesDTO> getActivities() {
        return this.servico.getActivities();
    }

    //Scheduling
    @GetMapping("/scheduling")
    private SchedulesDTO getSchedulingbyId(@RequestHeader String id) throws Exception {
        return this.servico.getSchedulingbyID(id);
    }

    @DeleteMapping("scheduling")
    public void removeScheduling(@RequestHeader String remove) throws Exception {
        this.servico.removeSched(remove);
    }

    @GetMapping("schedules")
    public ArrayList<SchedulesDTO> getSchedulesByCustomerID(@RequestHeader String id) {
        return this.servico.getSchedulesByCustomerID(id);
    }
}