package raisetech.studet.management;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class studentController {

	//名前をキー、年齢を値として保持するMap
	private Map<String,Integer> people = new HashMap<>();

	//コンストラクタで1件だけ初期データを追加
	public studentController(){
		people.put("EnamiKoji",37);
	}

	//GET POST
	//GETは取得する、リクエストを受け取る()
	//POSTは情報を与える,渡す(新規登録、更新)


	//全件取得
    @GetMapping
	public Map<String,Integer> getAllStudent(){
		return people;
	}

	//名前を追加
	@PostMapping
	public String addStudent(@RequestParam String name, @RequestParam int age){
		people.put(name,age);
		return name + "を追加しました。(年齢：" + age + "歳です。)";
	}
    //年齢を更新
	@PostMapping("/updateAge")
	public String updateStudentAge(@RequestParam String name, @RequestParam int age) {
        if(people.containsKey(name)){
            people.put(name,age);
            return name + "の年齢を" + age + "に変更しました。";
        }else {
            return name + "は存在しません。";
        }
    }

    //名前を更新
	@PostMapping("/updateName")
	public String updateStudentName(@RequestParam String oldName, @RequestParam String newName){
        if(people.containsKey(oldName)){
            int age = people.remove(oldName);
            people.put(newName,age);
            return oldName + "を" + newName + "に更新しました。";
        }else {
            return oldName + "は存在しません。";
        }
    }
}
