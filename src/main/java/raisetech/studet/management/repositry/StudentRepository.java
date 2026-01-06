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

    /**
     * 全件検索します。
     * @return 全件検索した受講生情報の一覧
     */
    @Select("SELECT * FROM students")
    List<Student> searchStudent();

    /**
     * 全件検索します。
     * @return 全件検索した受講生コース情報の一覧
     */
    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentCourse();

    @Insert("INSERT INTO students(name, kana_name, nick_name, email, area, age, sex, remark, is_deleted) " +
            "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{sex}, #{remark}, false)")

    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    void registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id, course_name, course_start_at, course_end_at)"
            + "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentCourse(StudentsCourses studentCourse);
}
