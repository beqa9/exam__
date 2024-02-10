package exam.demo.controllers;

import exam.demo.entities.Group;
import exam.demo.models.GroupModel;
import exam.demo.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping()
    public List<GroupModel> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return groups.stream()
                .map(group -> GroupModel.builder()
                        .studentId(group.getStudent().getId())
                        .teacherId(group.getTeacher().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Group getGroupById(@RequestParam Integer id) {
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteGroupById(@PathVariable Integer id) {
        groupService.deleteGroupById(id);
        return ResponseEntity.ok("Teacher with ID " + id + " deleted successfully.");
    }
}