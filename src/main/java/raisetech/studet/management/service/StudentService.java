package raisetech.studet.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentsCourses;
import raisetech.studet.management.domain.StudentDetail;
import raisetech.studet.management.repositry.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> searchStudentList(){
       return repository.searchStudent();
    }

    public List<StudentsCourses> searchStudentCourse(){
       return repository.searchStudentCourse();
    }

    @Transactional
    public void registerStudent(StudentDetail studentDetail){

        repository.registerStudent(studentDetail.getStudent());
        //TODO:コース情報登録も行う。
        for (StudentsCourses studentsCourses : studentDetail.getStudentsCourses()){
            studentsCourses.setStudentId(studentDetail.getStudent().getStudentId());
            studentsCourses.setCourseStartAt(LocalDateTime.now());
            studentsCourses.setCourseEndAt(LocalDateTime.now().plusYears(1));
            repository.registerStudentCourse(studentsCourses);
        }

    }
}
