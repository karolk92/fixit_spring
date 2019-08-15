package com.sellions.fixit.parameter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class ParameterName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String value;

    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Parameter> parameters = new HashSet<>();

}
