package bimaputra.employeetask.service.impl;

import bimaputra.employeetask.dto.employee.EmployeeDTO;
import bimaputra.employeetask.entity.Employee;
import bimaputra.employeetask.repository.EmployeeRepository;
import bimaputra.employeetask.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;


  @Override
  public List<Employee> getAllEmployee() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee createEmployee(EmployeeDTO employeeDTO) {
    return employeeRepository.save(convertDTOToEmployee(employeeDTO));
  }

  @Override
  public Optional<Employee> getEmployeeById(Long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Optional<Employee> getEmployeeByName(String name) {
    return employeeRepository.findByName(name);
  }

  @Override
  public void deleteEmployee(Employee employee) {
    employeeRepository.delete(employee);
  }

  @Override
  public Employee updateEmployee(Employee oldEmployee, EmployeeDTO employeeDTO) {
    oldEmployee.setName(employeeDTO.getName());
    return employeeRepository.save(oldEmployee);
  }


  private Employee convertDTOToEmployee(EmployeeDTO employeeDTO) {
    return Employee.builder().name(employeeDTO.getName()).build();
  }

}
