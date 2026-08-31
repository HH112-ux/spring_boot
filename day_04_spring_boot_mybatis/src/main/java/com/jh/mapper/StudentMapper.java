package com.jh.mapper;

import com.jh.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectList();

    @Select("select * from student where id=#{id}")
    Student selectId(Integer id);

    @Insert("insert into student values(null,#{name},#{age},#{gender})")
    int save(Student student);

    @Update("update student set name=#{name},age=#{age},gender=#{gender} where id=#{id}")
    int update(Student student);

    @Delete("delete from student where id=#{id}")
    int delete(Integer id);
}
