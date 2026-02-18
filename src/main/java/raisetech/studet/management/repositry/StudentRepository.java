package raisetech.studet.management.repositry;

import org.apache.ibatis.annotations.*;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentsCourses;

import java.util.List;

// /**を入力してEnterを押すとコメントが残せる。クラス名やメソッド名にカーソルでコメントの情報が見れる。

/**
 * 受講生情報を扱うリポジトリ
 * 全件検索や単一条件の検索、コース情報の検索が行えるクラスです。
 */
@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students")
    List<Student> search();

    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student searchStudent(String studentId);


    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentCourseList();

    @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
    List<StudentsCourses> searchStudentCourse(String studentId);

    @Insert("INSERT INTO students(name, kana_name, nick_name, email, area, age, sex, remark, is_deleted) " +
            "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{sex}, #{remark}, false)")
    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    void registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id, course_name, course_start_at, course_end_at)"
            + "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentCourse(StudentsCourses studentCourse);

    @Update("UPDATE students SET name = #{name}, kana_name = #{kanaName}, nick_name = #{nickName}, " +
            "email = #{email}, area = #{area}, age = #{age}, sex = #{sex},  remark = #{remark}, " +
            "is_deleted = #{isDeleted} WHERE student_id = #{studentId}")
    void updateStudent(Student student);

    @Update("UPDATE students_courses SET course_name = #{courseName} WHERE id = #{id}")
    void updateStudentCourse(StudentsCourses studentCourses);
}
