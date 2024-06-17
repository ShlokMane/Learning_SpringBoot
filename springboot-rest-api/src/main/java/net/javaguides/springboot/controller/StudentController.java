package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> student() {
        Student student = new Student(7, "Shlok", "Mane");
//        return new ResponseEntity<>(student, HttpStatus.CREATED);
//        return ResponseEntity.ok(student);
          return ResponseEntity.ok().header("custom-header", "eysendingjwtfromheader").body(student);
    }

    @GetMapping("all-students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add( new Student(7, "Shlok", "Mane"));
        students.add( new Student(9, "John ", "Doe"));
        return ResponseEntity.ok(students);
    }

    //Spring Boot REST API with Path Variable
    @GetMapping("students/{id}")
    public ResponseEntity<Student>  studentPathVariable(@PathVariable("id") int studentID) {
        return ResponseEntity.ok(new Student(studentID, "Shlok", "Mane"));
    }

    //Spring Boot REST API with Request Param
    //Example: http://localhost:8080/students/query?id=7&firstName=Shlok&lastName=Mane
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    //Spring Boot REST API to handle HTTP POST Request
    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring Boot API to handle HTTP PUT Request - update the existing resource

    @PutMapping("student/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    //Spring Boot REST API that handles HTTP Delete Request

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
