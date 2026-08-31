package com.jh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String gender;
    private Integer age;
    private Integer chinese;
    private Integer math;
    private Integer english;
}
