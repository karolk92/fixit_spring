package com.sellions.fixit.device.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sellions.fixit.category.entity.Category;
import com.sellions.fixit.comment.entity.Comment;
import com.sellions.fixit.enums.Condition;
import com.sellions.fixit.parameter.entity.Parameter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Condition condition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Parameter> parameters = new HashSet<>();

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Comment> comments = new HashSet<>();

    public Device(String name, Category category, Condition condition) {
        this.name = name;
        this.category = category;
        this.condition = condition;
    }
}
