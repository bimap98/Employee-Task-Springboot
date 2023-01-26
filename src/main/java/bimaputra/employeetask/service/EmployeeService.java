package bimaputra.employeetask.service;

import bimaputra.employeetask.dto.employee.EmployeeDTO;
import bimaputra.employeetask.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

  List<Employee> getAllEmployee();

  Employee createEmployee(EmployeeDTO employeeDTO);

  Optional<Employee> getEmployeeById(Long id);

  Optional<Employee> getEmployeeByName(String name);

  void deleteEmployee(Employee employee);

  Employee updateEmployee(Employee oldEmployee, EmployeeDTO employeeDTO);


}
