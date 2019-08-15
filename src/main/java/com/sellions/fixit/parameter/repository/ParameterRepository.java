package com.sellions.fixit.parameter.repository;

import com.sellions.fixit.parameter.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    List<Parameter> getParametersByDeviceId(Long id);
 }
