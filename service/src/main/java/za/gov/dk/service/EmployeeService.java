/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.dk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.dk.domain.Employee;
import za.gov.dk.persistence.EmployeeRepository;

/**
 *
 * @author S2028389
 */
@Service
public class EmployeeService implements EmployeeServiceLocal {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()
        ->new IllegalArgumentException("The requested id[" + id + "]does not exist"));
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteAll() {
         employeeRepository.deleteAll();
    }

    @Override
    public Employee deleteById(Long id) {
        Employee emp=findById(id);
        if(emp!=null){
        employeeRepository.deleteById(id);
        }
        return emp;
    }

    @Override
    public Employee findEmployeeByEmployeeNum(String identifier) {
        return employeeRepository.findEmployeeByEmployeeNum(identifier);
    }

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean isExist(Employee employee) {
        return employeeRepository.findById(employee.getId())!=null;
    }

    @Override
    public long count() {
        return employeeRepository.count();
    }

}
