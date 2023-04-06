package com.example.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")

    private String surname;
    @Column(name = "level")

    private Integer level;
    @Column(name = "age")

    private Integer age;
    @Column(name = "gender")

    private String gender;
    @Column(name = "created_date")

    private LocalDateTime createdDate;
}
