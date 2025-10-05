package raisetech.studet.management.repositry;

import org.apache.ibatis.annotations.*;
import raisetech.studet.management.data.Student;
import raisetech.studet.management.data.StudentCourse;

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
    List<StudentCourse> searchStudentCourse();

}
