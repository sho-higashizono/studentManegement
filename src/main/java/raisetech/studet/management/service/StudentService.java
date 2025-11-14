package raisetech.studet.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;
import raisetech.studet.management.repositry.StudentRepository;

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

    public List<StudentCourse> searchStudentCourse(){
       return repository.searchStudentCourse();
    }
}
