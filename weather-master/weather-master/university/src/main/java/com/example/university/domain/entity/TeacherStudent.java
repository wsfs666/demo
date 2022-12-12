package com.example.university.domain.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "teacher_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherStudent {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "stu_id")
    private String stuId;

    @Column(name = "teacher_id")
    private String teacherId;
}
