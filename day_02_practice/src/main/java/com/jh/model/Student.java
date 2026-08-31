package com.jh.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生对象", description = "学生信息")
public class Student {

    @ApiModelProperty(value = "学生id", required = true, example = "1")
    private Integer id;

    @ApiModelProperty(value = "学生姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "学生性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "学生年龄", example = "20")
    private Integer age;
}
