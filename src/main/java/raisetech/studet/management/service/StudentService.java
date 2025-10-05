package raisetech.studet.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;
import raisetech.studet.management.repositry.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> searchStudent(){
        //ここで処理を行う
        //検索処理
        repository.searchStudent();
        //絞り込みをする。年齢が30代の人のみ抽出する。
        //抽出したリストをコントローラーにわたす。
        return repository.searchStudent().stream()
                .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
                .collect(Collectors.toList());
    }

    public List<StudentCourse> searchStudentCourse(){
        //絞り込みで「Java」のみ抽出する。
         //抽出したリストをコントローラーにわたす。
        return repository.searchStudentCourse().stream()
                .filter(studentCourse -> "Java".equals(studentCourse.getCourseName()))
                .collect(Collectors.toList());
    }
}
