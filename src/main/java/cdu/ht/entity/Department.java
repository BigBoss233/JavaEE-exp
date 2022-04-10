package cdu.ht.entity;


import org.springframework.stereotype.Component;

@Component
public class Department {
    private Integer id;
    private Integer number;
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    public Department() {
    }

    public Department(Integer id, Integer number, String name) {
        this.id = id;
        this.number = number;
        this.name = name;
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
}
