package com.protfolio.sessioneighth.service;

import com.protfolio.sessioneighth.exception.ServiceNotFoundException;
import com.protfolio.sessioneighth.model.ProtfolioService;
import com.protfolio.sessioneighth.repository.ProtfolioServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class APIService {

    @Autowired
    private ProtfolioServiceRepository protfolioServiceRepository;


    public List<ProtfolioService> getAllServices(){
        List<ProtfolioService> services = new ArrayList<>();
        protfolioServiceRepository.findAll().forEach(services::add);
        return services;
    }

    public ProtfolioService saveService(ProtfolioService protfolioService) {
        return protfolioServiceRepository.save(protfolioService);
    }

    public ProtfolioService updateService(Integer id, ProtfolioService protfolioService){
        Optional<ProtfolioService> optionalService = protfolioServiceRepository.findById(id);

        if(optionalService.isPresent()){
            ProtfolioService updateableService =  optionalService.get();
            updateableService.setServiceName(protfolioService.getServiceName());
            updateableService.setServiceDescription(protfolioService.getServiceDescription());
            updateableService.setServiceIcon(protfolioService.getServiceIcon());

            return protfolioServiceRepository.save(updateableService);
        }else{
            throw new ServiceNotFoundException("The service you are trying to update is not available");
        }
    }

    public void deleteService(Integer id){
        try{
            protfolioServiceRepository.deleteById(id);
        }catch (EmptyResultDataAccessException ex){
            throw new ServiceNotFoundException("The service you are trying to delete is not available");
        }
    }
}
