package exam.demo.service;

import exam.demo.entities.Teacher;
import exam.demo.models.TeacherModel;
import exam.demo.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        return optionalTeacher.orElse(null);
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher addTeacherByModel(TeacherModel teacherModel) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherModel.FirstName());
        teacher.setLastName(teacherModel.LastName());
        teacher.setEmail(teacherModel.Email());
        teacher.setPhoneNUmber(teacherModel.PhoneNumber());
        teacher.setPrivateId(teacherModel.PrivateId());
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacherByIdAndModel(Integer id, TeacherModel teacherModel) {
        Teacher existingTeacher = teacherRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            existingTeacher.setFirstName(teacherModel.FirstName());
            existingTeacher.setLastName(teacherModel.LastName());
            existingTeacher.setEmail(teacherModel.Email());
            existingTeacher.setPhoneNUmber(teacherModel.PhoneNumber());
            existingTeacher.setPrivateId(teacherModel.PrivateId());
            return teacherRepository.save(existingTeacher);
        }
        return null;
    }
}