package raisetech.studet.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Enami Koji";
	private  int age = 37;

	public static void main(String[] args) {
		//localhost:8080
		SpringApplication.run(Application.class, args);
	}
	//GET POST
	//GETは取得する、リクエストを受け取る()
	//POSTは情報を与える,渡す(新規登録、更新)
@GetMapping("/studentInfo")
	public String getStudentInfo(){
		return name + " " + age + "歳です。";
	}
	@PostMapping("/studentInfo")
	public void setStudentInfo(String name, int age){
		this.name = name;
		this.age = age;
	}

	@PostMapping("/updateStudentName")
	public void updateStudentName(String name){
		this.name = name;
	}
	@PostMapping("/updateStudentAge")
	public void updateStudentAge(int age){
		this.age = age;
	}
}
