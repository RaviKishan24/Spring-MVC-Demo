package com.SpringMVC.controller;

import com.SpringMVC.entity.Student;
import com.SpringMVC.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentResponse=studentService.createStudent(student);
        return  ResponseEntity.ok(studentResponse);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
       Student studentResponse= studentService.getStudent(id);
       if(studentResponse== null){
           return  ResponseEntity.notFound().build();
       }
       return  ResponseEntity.ok(studentResponse);
    }

    @GetMapping
    public  ResponseEntity <List<Student>>getAll(){
        List<Student> studentsAllResponse=studentService.findAll();

        if(studentsAllResponse.isEmpty()){
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(studentsAllResponse);

    }

}
