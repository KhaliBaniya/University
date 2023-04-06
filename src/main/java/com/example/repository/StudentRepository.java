package com.example.repository;

import com.example.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<StudentEntity,Integer> {
    /*
  6. Get method by each field. (getByName,
  getBySurname, getByLevel, getByAge, getByGender) +
  7. Get StudentList by Given Date.  +
  8. Get StudentList  between given dates. +
    */
    List<StudentEntity> findByName(String name);
    List<StudentEntity> findBySurname(String surname);
    List<StudentEntity> findByLevel(Integer level);
    List<StudentEntity> findByAge(Integer age);
    List<StudentEntity> findByGender(String gender);





}
