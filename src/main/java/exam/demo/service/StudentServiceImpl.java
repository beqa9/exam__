package exam.demo.service;

import exam.demo.entities.Student;
import exam.demo.models.StudentModel;
import exam.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student addStudentByModel(StudentModel studentModel) {
        Student student = new Student();
        student.setFirstName(studentModel.FirstName());
        student.setLastName(studentModel.LastName());
        student.setEmail(studentModel.Email());
        student.setPhoneNUmber(studentModel.PhoneNumber());
        student.setPrivateId(studentModel.PrivateId());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentByIdAndModel(Integer id, StudentModel studentModel) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setFirstName(studentModel.FirstName());
            existingStudent.setLastName(studentModel.LastName());
            existingStudent.setEmail(studentModel.Email());
            existingStudent.setPhoneNUmber(studentModel.PhoneNumber());
            existingStudent.setPrivateId(studentModel.PrivateId());
            return studentRepository.save(existingStudent);
        }
        return null;
    }
}

