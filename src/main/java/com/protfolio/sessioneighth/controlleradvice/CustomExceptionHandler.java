package com.protfolio.sessioneighth.controlleradvice;

import com.protfolio.sessioneighth.exception.ServiceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<Object> handleServiceNotFound(ServiceNotFoundException serviceNotFoundException){
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", "error");
        map.put("timeStamp", new Date());
        map.put("error", serviceNotFoundException.getMessage());

        return ResponseEntity.status(404).body(map);
    }
}
