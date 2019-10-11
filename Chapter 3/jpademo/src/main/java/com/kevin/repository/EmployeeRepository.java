package com.kevin.repository;

import com.kevin.domain.Employee;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

//public interface EmployeeRepository extends Repository<Employee, Integer> {

@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {

   Employee findByName(String name);

   // where name = ?1 and age = ?2
   List<Employee> findByNameAndAge(String name, Integer age);

   // where name = ?1 or age = ?2
   List<Employee> findByNameOrAge(String name, Integer age);

   // where id in(?)
   List<Employee> findByIdIn(List<Integer> ids);

   // where id in(?) or age = 12
   List<Employee> findByIdInOrAge(List<Integer> ids, Integer age);


}
