package com.lfj.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Girl {

    private String id;

    @NotEmpty(message = "The name should not be empty!")
    private String name;

    @Size(min = 14, message = "The age of girl should be lower than 14!")
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
