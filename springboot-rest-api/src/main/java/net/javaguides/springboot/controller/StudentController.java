package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //Spring Boot REST API to handle HTTP POST Request
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot API to handle HTTP PUT Request - update the existing resource

    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
