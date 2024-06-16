package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Spring Boot REST API with Path Variable
    @GetMapping("students/{id}")
    public Student  studentPathVariable(@PathVariable("id") int studentID) {
        return new Student(studentID, "Shlok", "Mane");
    }

    //Spring Boot REST API with Request Param
    //Example: http://localhost:8080/students/query?id=7&firstName=Shlok&lastName=Mane
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}
