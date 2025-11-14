package raisetech.studet.management.domain;

import lombok.Getter;
import lombok.Setter;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;

import java.util.List;

@Getter
@Setter
public class StudentDetail {

    private Student student;
    private List<StudentCourse> studentCourse;
}
