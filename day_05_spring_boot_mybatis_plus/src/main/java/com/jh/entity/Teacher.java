package com.jh.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("teacher")
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "teacher_name")
    private String teacherName;
    private String gender;
    private Integer age;
    private Integer deleted;
}
