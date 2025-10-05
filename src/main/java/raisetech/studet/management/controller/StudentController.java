package raisetech.studet.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;
import raisetech.studet.management.service.StudentService;

import java.util.List;

@RestController
public class StudentController {



    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    //GET POST
    //GETは取得する、リクエストを受け取る()
    //POSTは情報を与える,渡す(新規登録、更新)

    //全件取得
    @GetMapping("/studentList")
    public List<Student> getStudentList(){
        return service.searchStudent();
    }

    @GetMapping("/studentCourseList")
    public List<StudentCourse> getStudentCourseList(){
        return service.searchStudentCourse();
    }
}
