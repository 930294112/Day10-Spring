package com.lanou.domain;

/**
 * Created by dllo on 17/10/23.
 */
public class Student {
    private int id;
    private String name;
    private String gender;
    private int age;
    private Person person; //引用其他对象

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Student() {
        System.out.println("student无参");
    }

    public Student(int id, String name, String gender, int age) {
        System.out.println("Student4参");
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student(String name, String gender, int age) {
        System.out.println("Student3参");
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", person=" + person +
                '}';
    }
}
