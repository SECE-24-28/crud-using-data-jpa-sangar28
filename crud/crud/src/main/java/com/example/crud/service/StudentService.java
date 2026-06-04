package com.example.crud.service;


import com.example.crud.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> students= new ArrayList<>(
            Arrays.asList(
            new Student(1,"John","SB"),
            new Student(2,"Doe","React")
    )
    );



    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentbyRollNo(int roll)
    {
        int index=0;
        boolean flag = true;
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).getId()==roll)
            {
                index=i;
                flag=false;
            }
        }
        if (flag) return new Student(0,"","");
        else return students.get(index);
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public String updateStudent(Student std) {
        for(Student s: students)
        {
            if(s.getId()==std.getId())
            {
                s.setName(std.getName());
                s.setCourse(std.getCourse());
            }
        }
        return "Success";
    }

    public String deleteStudent(int rno) {
//        for(Student s: students)
//        {
//            if(s.getId()==rno)
//            {
//                students.remove(s);
//            }
//        }

//        students.removeIf(s -> s.getId() == rno);

        int index=0;
        boolean flag=true;
        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).getId()==rno)
            {
                index=i;
                flag=false;
                break;
            }
        }
        if(flag) return "Success";
        else  return "Error";
//        return "Success";
    }
}
