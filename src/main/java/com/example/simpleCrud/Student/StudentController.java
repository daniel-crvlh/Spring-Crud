package com.example.simpleCrud.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student s){
        return new ResponseEntity<>(studentService.addStudent(s), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> removeStudent(@RequestBody Student s){
        return new ResponseEntity<>(studentService.removeStudent(s), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student s){
        return new ResponseEntity<>(studentService.updateStudent(s), HttpStatus.OK);
    }

}
