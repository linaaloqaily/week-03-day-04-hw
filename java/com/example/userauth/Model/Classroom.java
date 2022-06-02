package com.example.userauth.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Classroom {

    @Id
    @NotNull(message = "id is required")
    private Integer id;

    @NotEmpty(message = "name is required")
    private String name;


    @ManyToOne
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> students;

}
