package exam.demo.controllers;

import exam.demo.entities.Teacher;
import exam.demo.models.TeacherModel;
import exam.demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @PostMapping()
    public Teacher teacher(@RequestBody TeacherModel teacherModel) {
        return teacherService.addTeacherByModel(teacherModel);
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@RequestParam Integer id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}/update")
    public Teacher updateTeacher(@PathVariable Integer id, @RequestBody TeacherModel teacherModel) {
        return teacherService.updateTeacherByIdAndModel(id, teacherModel);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Integer id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok("Teacher with ID " + id + " deleted successfully.");
    }
}