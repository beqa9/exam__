package exam.demo.service;

import exam.demo.entities.Group;
import exam.demo.models.GroupModel;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();

    Group getGroupById(Integer id);

    void deleteGroupById(Integer id);

    Group addGroupWithIds(GroupModel groupModel);
}
