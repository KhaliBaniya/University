package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
@Autowired
private StudentRepository studentRepository;
    public StudentDTO getById(Integer id) {
        StudentEntity entity = get(id);
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setLevel(entity.getLevel());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setCreatedDate(entity.getCreatedDate());
        //...
        return dto;
    }
    public boolean update(Integer id, StudentDTO studentDTO) {
        /*StudentEntity entity = studentRepository.get(id);
        if (entity == null) {
            throw new AppBadRequestException("Student not found: " + id);
        }*/
        StudentEntity entity = get(id);
        entity.setName(studentDTO.getName());
        entity.setSurname(studentDTO.getSurname());
        entity.setLevel(studentDTO.getLevel());
        entity.setAge(studentDTO.getAge());
        entity.setGender(studentDTO.getGender());
        entity.setCreatedDate(studentDTO.getCreatedDate());
        //......
        studentRepository.save(entity);
        return true;
    }


    public StudentDTO crate(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
        //
        // throw new PhoneAlreadyExistsException("Phone already exists");

        studentRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> iterable = studentRepository.findAll();
        List<StudentDTO> dtoList = new LinkedList<>();
        iterable.forEach(studentEntity -> {
            StudentDTO dto = new StudentDTO();
            dto.setId(studentEntity.getId());
            dto.setName(studentEntity.getName());
            dto.setSurname(studentEntity.getSurname());

            dtoList.add(dto);

        });
        return dtoList;
    }
    public boolean delete(Integer id) {
        /*StudentEntity entity = studentRepository.get(id);
        if (entity == null) {
            throw new AppBadRequestException("Student not found: " + id);
        }*/
        StudentEntity entity = get(id);
        studentRepository.delete(entity);
        return true;
    }
    public StudentEntity get(Integer id) {
        Optional<StudentEntity > optional = studentRepository.findById(id);

        if (optional.get() == null) {
            throw new AppBadRequestException("Student not found: " + id);
        }
        return optional.get();
    }

//    public StudentEntity findName(String name){
//        List<StudentEntity> entity = studentRepository.findByName(name);
//
//       return entity;
//    }


}
