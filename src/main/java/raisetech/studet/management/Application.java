package raisetech.studet.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/studentCourseList")
public class Application {


	@Autowired
	public StudentRepository repository;


	public static void main(String[] args) {
		//localhost:8080
		SpringApplication.run(Application.class, args);
	}

	//GET POST
	//GETは取得する、リクエストを受け取る()
	//POSTは情報を与える,渡す(新規登録、更新)

	//全件取得
	@GetMapping
	public List<StudentCourse> getAllStudentList(){
		return repository.search();
	}

}
