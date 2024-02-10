package exam.demo.service;

import exam.demo.entities.Student;
import exam.demo.models.StudentModel;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student addStudentByModel(StudentModel studentModel);

    Student getStudentById(Integer id);

    Student updateStudentByIdAndModel(Integer id, StudentModel studentModel);

    void deleteStudentById(Integer id);
}
