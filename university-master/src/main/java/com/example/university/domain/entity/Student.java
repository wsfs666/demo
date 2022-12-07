package com.example.university.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
