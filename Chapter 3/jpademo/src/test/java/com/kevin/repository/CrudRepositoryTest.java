package com.kevin.repository;

import com.kevin.SpringDataTest;
import com.kevin.domain.Employee;
import org.junit.Test;

public class CrudRepositoryTest extends SpringDataTest {

    @Test
    public void test_curd(){

        Employee employee = new Employee();
        employee.setAge(12);
        employee.setName("test");

        employeeCrudRepository.save(employee);

    }

}
