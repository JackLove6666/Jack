package java8.stream;

import java.time.LocalDateTime;

public class Student extends Person{

    private Integer id;

    private String name;

    private boolean gender;

    private Integer age;

    private LocalDateTime birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer id, String name, boolean gender, Integer age, LocalDateTime birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }
}
