package com.example.university.domain.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.*;

import org.springframework.data.annotation.Id;


@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   @javax.persistence.Id
   @Id
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "s_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "t_id", referencedColumnName = "id"))
    private Set<Teacher> teachers=new HashSet<>();


    public Student(String id, String name) {
        this.id=id;
        this.name=name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }
}
