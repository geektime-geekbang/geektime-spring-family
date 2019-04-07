package com.kevin;

import com.kevin.repository.EmployeeCrudRepository;
import com.kevin.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class SpringDataTest {

    private ApplicationContext ctx = null;

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected EmployeeCrudRepository employeeCrudRepository;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");

        employeeRepository = ctx.getBean(EmployeeRepository.class);
        employeeCrudRepository = ctx.getBean(EmployeeCrudRepository.class);

        System.out.println("setup");
    }
    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public  void test_entityManagerFactory(){

    }
}
