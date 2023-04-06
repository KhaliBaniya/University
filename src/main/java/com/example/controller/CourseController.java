package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
@Autowired
private CourseService courseService;
/*
  1. Create Course
  2. Get Course by id.
  3. Get Course list. return all.
  4. Update Course.
  5. Delete Course
 */

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody CourseDTO dto) {
        CourseDTO response = courseService.crate(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> list = courseService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        CourseDTO dto = courseService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CourseDTO studentDTO) {
        return ResponseEntity.ok(courseService.update(id, studentDTO));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(courseService.delete(id));
    }
}
