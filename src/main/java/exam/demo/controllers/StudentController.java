package exam.demo.controllers;

import exam.demo.entities.Student;
import exam.demo.models.StudentModel;
import exam.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping()
    public Student student(@RequestBody StudentModel studentModel) {
        return studentService.addStudentByModel(studentModel);
    }
    @GetMapping("/{id}")
    public Student getStudentById(@RequestParam Integer id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}/update")
    public Student updateStudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        return studentService.updateStudentByIdAndModel(id, studentModel);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
    }
}