package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

  /*
  1. Create student +
  2. Get Student List. return all.+
  3. Get student by id.+
  4. Update student.+
  5. Delete Student by id.+
  6. Get method by each field. (getByName, getBySurname, getByLevel, getByAge, getByGender)
  7. Get StudentList by Given Date.
  8. Get StudentList  between given dates.
  */
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO) {
        StudentDTO response = studentService.crate(studentDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> getAll() {
        List<StudentDTO> list = studentService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/name")
    public ResponseEntity<List<StudentEntity>> findByName(@RequestParam String name) {
        return new ResponseEntity(studentRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/surname")
    public ResponseEntity<List<StudentEntity>> findBySurname(@RequestParam String surname) {
        return new ResponseEntity(studentRepository.findBySurname(surname), HttpStatus.OK);
    }

    @GetMapping("/level")
    public ResponseEntity<List<StudentEntity>> findByLevel(@RequestParam Integer level) {
        return new ResponseEntity(studentRepository.findByLevel(level), HttpStatus.OK);
    }

    @GetMapping("/age")
    public ResponseEntity<List<StudentEntity>> findByAge(@RequestParam Integer age) {
        return new ResponseEntity(studentRepository.findByAge(age), HttpStatus.OK);
    }

    @GetMapping("/gender")
    public ResponseEntity<List<StudentEntity>> findByGender(@RequestParam String gender) {
        return new ResponseEntity(studentRepository.findByGender(gender), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        StudentDTO dto = studentService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

}
