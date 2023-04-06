package com.example.service;

import com.example.dto.CourseDTO;
import com.example.entity.CourseEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public CourseDTO getById(Integer id) {
        CourseEntity entity = get(id);
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());

        dto.setCreatedDate(entity.getCreatedDate());
        //...
        return dto;
    }
    public boolean update(Integer id, CourseDTO dto) {

        CourseEntity entity = get(id);
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(dto.getCreatedDate());
        //......
        courseRepository.save(entity);
        return true;
    }


    public CourseDTO crate(CourseDTO dto) {
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setDuration(dto.getDuration());
        entity.setPrice(dto.getPrice());
        entity.setCreatedDate(dto.getCreatedDate());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }

        //
        // throw new PhoneAlreadyExistsException("Phone already exists");

        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }
    public List<CourseDTO> getAll() {
        Iterable<CourseEntity> iterable = courseRepository.findAll();
        List<CourseDTO> dtoList = new LinkedList<>();
        iterable.forEach(courseEntity -> {
            CourseDTO dto = new CourseDTO();
            dto.setId(dto.getId());
            dto.setName(dto.getName());
            dto.setPrice(dto.getPrice());
            dto.setDuration(dto.getDuration());
            dto.setCreatedDate(dto.getCreatedDate());

            dtoList.add(dto);

        });
        return dtoList;
    }
    public boolean delete(Integer id) {
        /*CourseEntity entity = courseRepository.get(id);
        if (entity == null) {
            throw new AppBadRequestException("Student not found: " + id);
        }*/
        CourseEntity entity = get(id);
        courseRepository.delete(entity);
        return true;
    }
    public CourseEntity get(Integer id) {
        Optional<CourseEntity > optional = courseRepository.findById(id);

        if (optional.get() == null) {
            throw new AppBadRequestException("Student not found: " + id);
        }
        return optional.get();
    }
}
