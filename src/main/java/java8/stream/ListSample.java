package java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * List 分组、求和、去重、求并集、差集、过滤
 */

@Slf4j
public class ListSample {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        List<Student> commentList = new ArrayList<>();
        studentList.add(new Student(1,"jack",false, 18,LocalDateTime.now()));
        studentList.add(new Student(2,"jack1",true,19,LocalDateTime.now()));
        studentList.add(new Student(3,"jack",true,20,LocalDateTime.now()));
        commentList.add(new Student(1,"jack",false, 18,LocalDateTime.now()));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(LocalDateTime.now());
//        System.out.println(format);
//        groupOne(studentList);
//        filter(studentList);
//        differenceSet(studentList,  commentList);
//        distinct(studentList);

        Integer sumAge = getSumAge(studentList);
        System.out.println("sumAge:"+sumAge);
    }

    /**
     * 分组指定字段
     * @param list
     */
    public static void groupOne(List<Student> list){
        Map<String, List<Student>> listMap = list.stream().collect(Collectors.groupingBy(Student::getName));
        for (Map.Entry<String, List<Student>> entry : listMap.entrySet()) {
            String key = entry.getKey();
            List<Student> value = entry.getValue();
            log.info("key {}, value {}",key,value);
        }
    }

    public static void  groupMany(List<Student> list){
        Map<String, Map<Boolean, List<Student>>> stringMapMap = list.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::isGender)));
        Set<Map.Entry<String, Map<Boolean, List<Student>>>> entries = stringMapMap.entrySet();
        for (Map.Entry<String, Map<Boolean, List<Student>>> entry : entries) {
            String key = entry.getKey();
            Map<Boolean, List<Student>> value = entry.getValue();
        }
    }

    public static void filter(List<Student> list){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if(!Objects.isNull(list)){
            List<Student> studentList = list.stream().filter(item -> item.getName() != null && dateTimeFormatter.format(item.getBirthday()).equals("2022-08-02")).collect(Collectors.toList());
            for (Student student : studentList) {
                System.out.println("student:"+ student.getName()+student.getBirthday());
            }
        }
    }

    //Collectors.toCollection：set去重
    public static void distinct(List<Student> list){
        ArrayList<Student> students = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new));

        for (Student student : students) {
            System.out.println("name :"+student.getName());
        }
    }

    //求差集
    public static List<Student> differenceSet(List<Student> all, List<Student> comment){
        List<Student> notCommentList = all.stream()
                .filter(notComment -> !comment.stream().map(a -> a.getName()).collect(Collectors.toList()).contains(notComment.getName()))
                .collect(Collectors.toList());
        System.out.println(notCommentList+ "size"+notCommentList.size());
        return notCommentList;
    }

    //求和
    public static Integer getSumAge(List<Student> studentList){
        int sum = studentList.stream().mapToInt(s -> s.getAge()).sum();
        return sum;
    }


    //list to map
    public static Map<Integer, Student> listToMap(List<Student> studentList){
        Map<Integer, Student> studentMap = studentList.stream().collect(Collectors.toMap(s -> s.getId(), s -> s));
        return studentMap;
    }






}
