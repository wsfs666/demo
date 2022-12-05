package com.example.university.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author：舒望
 * @CreateTime：2022-12-04 22:08
 * @Description： TODO
 * @Version：1.0.0
 */
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
