package com.example.crud.controller;

import com.example.crud.model.Student;
import com.example.crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService s;

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return s.getAllStudents();
    }

    @GetMapping("students/{rno}")
    public Student getStudentbyId(@PathVariable int rno) {
        return s.getStudentbyRollNo(rno);
    }

    @PostMapping("students") //can use the same endpoint when the request type is different
        public String addStudent(@RequestBody Student std)
        {
            s.addStudent(std);
            return "Success";
        }

    @PutMapping("students/{rno}")
    public String updateStudent(@PathVariable("rno") int r, @RequestBody Student std)
    {
        return s.updateStudent(std);
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno) {
        return s.deleteStudent(rno);
    }


}
