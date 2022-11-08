package com.example.challenge;

import com.example.challenge.DTO.ActivitiesDTO;
import com.example.challenge.DTO.CustomersDTO;
import com.example.challenge.DTO.SchedulesDTO;
import com.example.challenge.Entities.Activity;
import com.example.challenge.Entities.Customer;
import com.example.challenge.Interfaces.IActivities;
import com.example.challenge.Interfaces.ICustomers;
import com.example.challenge.Interfaces.ISchedules;
import com.example.challenge.Entities.Scheduling;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MyService {
    @Autowired
    private IActivities activitiesRepo;
    @Autowired
    private ICustomers customersRepo;
    @Autowired
    private ISchedules schedulesRepo;

    //Customer
    public CustomersDTO getCustomerById(String id) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = this.customersRepo.findAllById(id);
        log.info("Customer: -> {}", customer);

        if (Objects.isNull(customer)) {
            return new CustomersDTO();
        } else {
            log.info("CustomerDTO: -> {}", modelMapper.map(customer, CustomersDTO.class));

            return modelMapper.map(customer, CustomersDTO.class);
        }
    }

    public void addCustomer(CustomersDTO adiciona) {
        if (!Objects.isNull(adiciona)) {
            log.info("A adicionar customer");
            Customer customer = new Customer(adiciona.getFirstname(), adiciona.getLastname(), adiciona.getBirthdate(), adiciona.getFiscalNumber(),
                    adiciona.getMobile_number(), adiciona.getEmail());
            this.customersRepo.save(customer);
        }
    }

    public CustomersDTO update(CustomersDTO customer,String id) throws Exception { //devolver o user
        log.info("Update customer: -> {}", customer);
        CustomersDTO find = getCustomerById(id);
        ModelMapper moduleMapper = new ModelMapper();
        Customer costumer1 = moduleMapper.map(find, Customer.class);
        this.customersRepo.delete(costumer1);
        addCustomer(customer);
        return getCustomerById(customer.getId());
    }

    public CustomersDTO updatePatch(CustomersDTO customer, String id) throws Exception {
        log.info("Update Customer: -> {}", customer);
        CustomersDTO find = getCustomerById(id);
        ModelMapper moduleMapper = new ModelMapper();
        Customer costumer1 = moduleMapper.map(find, Customer.class);
        this.customersRepo.delete(costumer1);
        addCustomer(customer);
        return getCustomerById(customer.getId());
    }

    public void removeCust(String uid) {
        log.info("A remover Customer");
        UUID id = UUID.fromString(uid);
        log.info("ID: ->{}", id);
        this.customersRepo.deleteById(uid);
    }

    public void uploadPhoto(String filePath)throws IOException {
        log.info("Upload -> {}",filePath);
        String projectId = "acn-gcp-cloudtraining";
        Path pathToAFile = Paths.get(filePath);
        String bucketName = "pcosta";
        String objectName = pathToAFile.getFileName().toString().split("\\.")[0].toLowerCase();
        Storage.BlobTargetOption precondition = Storage.BlobTargetOption.doesNotExist();

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(GoogleCredentials.fromStream(new FileInputStream(
                "C:\\Users\\p.a.costa\\Downloads\\acn-gcp-cloudtraining-e25e96e68861.json"))).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)), precondition);
    }

    /**
     * Activity
     */
    public ActivitiesDTO getActivityById(String id) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Activity atividade = this.activitiesRepo.findAllById(id);
        log.info("Atividade: -> {}", atividade);

        if(Objects.isNull(atividade)){
            return new ActivitiesDTO();
        }
        else{
            return modelMapper.map(atividade,ActivitiesDTO.class);
        }
    }

    public ArrayList<ActivitiesDTO> getActivities(){
        log.info("Todas as atividades");

        ModelMapper modelMapper = new ModelMapper();
        return this.activitiesRepo.findAll().stream().map(e->modelMapper.map(e,ActivitiesDTO.class)).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Schedule
     */
    public SchedulesDTO getSchedulingbyID (String id) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Scheduling schedule = this.schedulesRepo.findAllById(id);
        log.info("Scheduling: -> {}",schedule);

        if(Objects.isNull(schedule)){
            return new SchedulesDTO();
        }
        else{
            return modelMapper.map(schedule,SchedulesDTO.class);
        }
    }

    public void removeSched(String remove) throws Exception {
        log.info("Estou a remover scheduling");

        this.schedulesRepo.deleteById(remove);
    }

    public ArrayList<SchedulesDTO> getSchedulesByCustomerID(String id){
        log.info("Todos os schedulings por Id de customer");
        ModelMapper modelMapper = new ModelMapper();
        return this.schedulesRepo.findAllBycustomerID(id).stream().map(e->modelMapper.map(e,SchedulesDTO.class)).collect(Collectors.toCollection(ArrayList::new));
    }
}
