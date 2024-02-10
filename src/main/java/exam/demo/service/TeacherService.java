package exam.demo.service;

import exam.demo.entities.Teacher;
import exam.demo.models.TeacherModel;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher addTeacherByModel(TeacherModel teacherModel);

    Teacher getTeacherById(Integer id);

    Teacher updateTeacherByIdAndModel(Integer id, TeacherModel teacherModel);

    void deleteTeacherById(Integer id);
}