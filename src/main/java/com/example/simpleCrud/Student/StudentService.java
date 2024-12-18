package com.example.simpleCrud.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student s){
        return studentRepository.save(s);
    }

    public String removeStudent(Student s){
        studentRepository.delete(s);
        return "Removed student successfully!";
    }

    public Student updateStudent(Student s){
        Student db_s = studentRepository.findById(s.getId()).get();
        db_s = s;
        return studentRepository.save(db_s);
    }

}
