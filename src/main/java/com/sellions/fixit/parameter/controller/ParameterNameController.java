package com.sellions.fixit.parameter.controller;

import com.sellions.fixit.parameter.entity.ParameterName;
import com.sellions.fixit.parameter.service.ParameterNameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/parameter/names")
public class ParameterNameController {

    private ParameterNameService parameterNameService;

    @GetMapping
    public ResponseEntity<List<ParameterName>> getAllParameterNames() {
        List<ParameterName> parameterNames = parameterNameService.getAllParameterNames();

        return new ResponseEntity<>(parameterNames, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> insertParameterName(@RequestBody ParameterName parameterName) {
        parameterNameService.addParameterName(parameterName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteParameterNameById(@PathVariable("id") Long id) {
        parameterNameService.deleteParameterNameById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
