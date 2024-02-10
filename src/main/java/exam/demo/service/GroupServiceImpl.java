package exam.demo.service;

import exam.demo.entities.Group;
import exam.demo.entities.Student;
import exam.demo.entities.Teacher;
import exam.demo.models.GroupModel;
import exam.demo.repositories.GroupRepository;
import exam.demo.repositories.StudentRepository;
import exam.demo.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public GroupServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group getGroupById(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElse(null);
    }

    @Override
    public void deleteGroupById(Integer id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group addGroupWithIds(GroupModel groupModel) {
        Optional<Student> optionalStudent = studentRepository.findById(groupModel.studentId());
        Optional<Teacher> optionalTeacher = teacherRepository.findById(groupModel.teacherId());
        if (optionalStudent.isPresent() && optionalTeacher.isPresent()) {
            Group group = new Group();
            group.setStudent(optionalStudent.get());
            group.setTeacher(optionalTeacher.get());
            return groupRepository.save(group);
        }
        return null; // Return null if either studentId or teacherId does not exist
    }


}
