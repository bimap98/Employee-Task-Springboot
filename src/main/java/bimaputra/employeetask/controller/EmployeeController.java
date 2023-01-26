package bimaputra.employeetask.controller;

import bimaputra.employeetask.dto.employee.EmployeeDTO;
import bimaputra.employeetask.entity.Employee;
import bimaputra.employeetask.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  @GetMapping("/")
  public List<Employee> getAllEmployee() {
    return employeeService.getAllEmployee();
  }

  @PostMapping
  public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
    return employeeService.createEmployee(employeeDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
    Optional<Employee> optEmployee = employeeService.getEmployeeById(id);
    if (optEmployee.isPresent()) {
      return new ResponseEntity<>(optEmployee.get(), HttpStatus.OK);
    } else {
      return noEmployeeFoundResponse(id);
    }
  }

  @GetMapping("")
  public ResponseEntity<?> getEmployeeByName(@RequestParam String name) {
    Optional<Employee> employeeByName = employeeService.getEmployeeByName(name);
    if (employeeByName.isPresent()) {
      return new ResponseEntity<>(employeeByName.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>("No employee found with name " + name, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
    Optional<Employee> optEmployee = employeeService.getEmployeeById(id);
    if (optEmployee.isPresent()) {
      employeeService.deleteEmployee(optEmployee.get());
      return new ResponseEntity<>(String.format("Employee with id: %d was deleted", id), HttpStatus.OK);
    } else {
      return noEmployeeFoundResponse(id);
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
    Optional<Employee> optEmployee = employeeService.getEmployeeById(id);
    if (optEmployee.isPresent()) {
      return new ResponseEntity<>(employeeService.updateEmployee(optEmployee.get(), employeeDTO), HttpStatus.OK);
    } else {
      return noEmployeeFoundResponse(id);
    }
  }

  private ResponseEntity<String> noEmployeeFoundResponse(Long id) {
    return new ResponseEntity<>("No employee found with id: " + id, HttpStatus.NOT_FOUND);
  }


}
