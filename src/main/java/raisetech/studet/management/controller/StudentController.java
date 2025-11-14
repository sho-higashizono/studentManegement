package raisetech.studet.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studet.management.controller.converter.StudentConverter;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;
import raisetech.studet.management.domain.StudentDetail;
import raisetech.studet.management.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {



    private StudentService service;
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    //GET POST
    //GETは取得する、リクエストを受け取る()
    //POSTは情報を与える,渡す(新規登録、更新)

    //全件取得
    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList(){
        List<Student> students = service.searchStudentList();
        List<StudentCourse> studentCourses = service.searchStudentCourse();

        return converter.convertStudentDetails(students, studentCourses);
    }



    @GetMapping("/studentCourseList")
    public List<StudentCourse> getStudentCourseList(){
        return service.searchStudentCourse();
    }
}
