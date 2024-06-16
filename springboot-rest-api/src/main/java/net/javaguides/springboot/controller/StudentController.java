package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student student() {
        Student student = new Student(7, "Shlok", "Mane");
        return student;
    }

    @GetMapping("all-students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add( new Student(7, "Shlok", "Mane"));
        students.add( new Student(9, "John ", "Doe"));
        return students;
    }
}
