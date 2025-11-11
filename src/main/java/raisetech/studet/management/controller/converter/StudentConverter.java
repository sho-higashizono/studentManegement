package raisetech.studet.management.controller.converter;

import org.springframework.stereotype.Component;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;
import raisetech.studet.management.domain.StudentDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public List<StudentDetail> convertStudentDetails(List<Student> students, List<StudentCourse> studentCourses) {
        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(student);

            List<StudentCourse> convertStudentCourses = studentCourses.stream().filter(studentCourse -> student.getStudentId().equals(studentCourse.getStudentId())).collect(Collectors.toList());

            studentDetail.setStudentCourse(convertStudentCourses);
            studentDetails.add(studentDetail);
        });
        return studentDetails;
    }
}
