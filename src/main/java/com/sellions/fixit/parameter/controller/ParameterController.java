package com.sellions.fixit.parameter.controller;

import com.sellions.fixit.parameter.service.ParameterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/parameters")
public class ParameterController {
    private ParameterService parameterService;

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteParameterById(@PathVariable("id") Long id) {
        parameterService.deleteParameterById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
