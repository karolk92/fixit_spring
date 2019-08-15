package com.sellions.fixit.parameter.service;

import com.sellions.fixit.parameter.entity.ParameterName;
import com.sellions.fixit.parameter.repository.ParameterNameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ParameterNameService {

    private ParameterNameRepository parameterNameRepository;

    public List<ParameterName> getAllParameterNames() {
        return parameterNameRepository.findAll();
    }

    public void addParameterName(ParameterName parameterName) {
        parameterNameRepository.save(parameterName);
    }

    public void deleteParameterNameById(Long id) {
        parameterNameRepository.deleteById(id);
    }
}
