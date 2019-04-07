package com.kevin.domain;


import javax.persistence.*;

/**
 * @Entity 指定实体的名称
 * @Table 指定数据库表的名称 如果没有该注解，默认使用实体名称作为表名
 */

@Entity
//@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//自动增长
    private Integer id;

    @Column(length = 20)
    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //@Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "id: ["+ id +"]" + "name: ["+ name +"]" + "age: ["+ age +"]" ;
    }
}
