package com.example.userauth.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Student {

    @Id
    @NotNull(message = "id is required")
    private Integer id;

    @NotEmpty(message = "name is required")
    private String name;

    @NotNull(message = "age is required")
    private Integer age;

    @NotEmpty(message = "major is required")
    private String major;



    @ManyToMany(mappedBy = "students") //كلمة students هو المتغير اللي بـ class room  اخر سطر انتبهي لازم يكون نفسه
    @JsonIgnore
    private Set<Classroom> classrooms;

}
