package raisetech.studet.management;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students_courses")
    List<StudentCourse> search();

}
