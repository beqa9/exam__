package exam.demo.models;

import lombok.Builder;

@Builder
public record StudentModel(
        String FirstName,
        String LastName,
        String Email,
        Integer PhoneNumber,
        Integer PrivateId

) {
}
