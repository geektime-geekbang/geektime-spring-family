package com.kevin.repository;

import com.kevin.SpringDataTest;
import com.kevin.domain.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryTest extends SpringDataTest {

    @Test
    public void test_findByName(){
        Employee employee = employeeRepository.findByName("zhangsan");

        System.out.println(employee.toString());
    }
    @Test
    public void test_findByNameAndAge(){
        List<Employee> employees = employeeRepository.findByNameAndAge("test", 12);

        for (Employee employee: employees) {

            System.out.println(employee.toString());
        }
    }


    @Test
    public void test_findByNameOrAge(){
        List<Employee> employees = employeeRepository.findByNameOrAge("test", 12);
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void test_findByIdIn(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Employee> employees = employeeRepository.findByIdIn(ids);
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
    @Test
    public void test_findByIdInOrAge(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Employee> employees = employeeRepository.findByIdInOrAge(ids, 13);
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }

}
