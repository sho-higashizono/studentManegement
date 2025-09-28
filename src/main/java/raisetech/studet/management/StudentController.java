package raisetech.studet.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	 public StudentRepository repository;


	//GET POST
	//GETは取得する、リクエストを受け取る()
	//POSTは情報を与える,渡す(新規登録、更新)


	//全件取得
    @GetMapping
	public String getAllStudent(@RequestParam String name){
		Student student = repository.searchByName(name);
        return student.getName() + " " + student.getAge() + "歳です。";
    }

	//名前を追加
	@PostMapping
	public String addStudent(@RequestParam String name, @RequestParam int age){
		repository.registerStudent(name,age);
		return name + "を追加しました。(年齢：" + age + "歳です。)";
	}
    //年齢を更新
	@PatchMapping
	public String updateStudentAge(@RequestParam String name,@RequestParam int age) {
		Student target = repository.searchByName(name);
        if(target != null){
			repository.updateStudent(name,age);
            return name + "の年齢を" + age + "に変更しました。";
        }else {
            return name + "は存在しません。";
        }
    }

	@DeleteMapping
	public String deleteStudent(@RequestParam String name){
		Student target = repository.searchByName(name);
		if(target != null){
			repository.deleteStudent(name);
			return name + "を削除しました。";
		} else {
			return name + "は存在しません。";
		}
	}
	}
