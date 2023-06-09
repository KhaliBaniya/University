package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "course")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name ")
    private String name;
    @Column(name = "price")
    private Integer  price;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
