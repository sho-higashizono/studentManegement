package raisetech.studet.management.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentCourse {

    private String id;
    private String studentId;
    private  String courseName;
    private LocalDateTime  course_start_at;
    private  LocalDateTime  course_end_at;
}
