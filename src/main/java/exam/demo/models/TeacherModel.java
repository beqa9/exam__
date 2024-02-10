package exam.demo.models;

import lombok.Builder;

@Builder
public record TeacherModel(
        String FirstName,
        String LastName,
        String Email,
        Integer PhoneNumber,
        Integer PrivateId

) {
}
