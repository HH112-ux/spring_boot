package com.jh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student extends Model<Student> {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer tid;
    @TableField(exist = false)
    private String teacherName;
}
