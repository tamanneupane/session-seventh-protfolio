package com.protfolio.sessioneighth.controller;

import com.protfolio.sessioneighth.model.PersonalInfo;
import com.protfolio.sessioneighth.model.ProtfolioService;
import com.protfolio.sessioneighth.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping(value = "/api/service")
    public List<ProtfolioService> getServices(){
        return apiService.getAllServices();
    }

    @PostMapping(value = "/api/service")
    public ProtfolioService createService(@RequestBody ProtfolioService protfolioService){
        System.out.println(protfolioService);
        return apiService.saveService(protfolioService);
    }

    @PutMapping(value = "/api/service/{id}")
    public String updateService(@PathVariable(name = "id") Integer id, @RequestBody ProtfolioService protfolioService){
        System.out.println(id);
        System.out.println(protfolioService);
        ProtfolioService updatedService = apiService.updateService(id,protfolioService);
        if(updatedService == null){
            return  "error";
        }
        return "Success";
    }

    @DeleteMapping(value = "/api/service/{id}")
    public String deleteService(@PathVariable(name = "id") Integer  id){
        apiService.deleteService(id);
        return "Success";
    }

}
