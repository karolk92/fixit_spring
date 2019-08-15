package com.sellions.fixit.parameter.repository;

import com.sellions.fixit.parameter.entity.ParameterName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterNameRepository extends JpaRepository<ParameterName, Long> {
}
