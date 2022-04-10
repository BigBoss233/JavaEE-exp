package cdu.ht.entity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Employee {
    private Integer id;
    private Integer number;
    private String name;
    private String gender;
    private Integer age;
    private Integer dep_id;
    private String dep_name;



    public Employee(Integer id, Integer number, String name, String gender, Integer age, Integer dep_id, String dep_name) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dep_id = dep_id;
        this.dep_name = dep_name;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                '}';
    }




    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDep_id() {
        return dep_id;
    }

    public void setDep_id(Integer dep_id) {
        this.dep_id = dep_id;
    }




}
