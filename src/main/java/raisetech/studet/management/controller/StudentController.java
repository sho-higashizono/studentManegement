package raisetech.studet.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.studet.management.controller.converter.StudentConverter;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentsCourses;
import raisetech.studet.management.domain.StudentDetail;
import raisetech.studet.management.service.StudentService;

import java.util.Arrays;
import java.util.List;

@Controller
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
    public String getStudentList(Model model) {
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentCourses = service.searchStudentCourse();

        model.addAttribute("studentList",
                converter.convertStudentDetails(students, studentCourses));
        return "studentList";
    }


    @GetMapping("/studentCourseList")
    public List<StudentsCourses> getStudentCourseList() {
        return service.searchStudentCourse();
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model){
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentsCourses(Arrays.asList(new StudentsCourses()));
        model.addAttribute("studentDetail", studentDetail);



        return "registerStudent";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result){
        if (result.hasErrors()){
            return "registerStudent";
        }
        //①新規受講生情報を登録する処理を実装
        service.registerStudent(studentDetail);
        //②コース情報も一緒に登録できるように実装
        return "redirect:/studentList";
    }
}
