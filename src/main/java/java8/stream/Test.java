package java8.stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {


        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"jack",false, 18, LocalDateTime.now()));
        studentList.add(new Student(2,"jack1",true,19,LocalDateTime.now()));
        studentList.add(new Student(3,"jack",true,20,LocalDateTime.now()));

        List<Person> personList = (List)studentList;
        for (Person person : personList) {
            System.out.println(person.getName());
            System.out.println(person.getId());
        }
    }
}
