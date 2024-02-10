package exam.demo.models;

import lombok.Builder;

@Builder
public record GroupModel(
        Integer studentId,
        Integer teacherId
) {
}