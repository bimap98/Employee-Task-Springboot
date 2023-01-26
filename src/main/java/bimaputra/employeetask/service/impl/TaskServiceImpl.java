package bimaputra.employeetask.service.impl;

import bimaputra.employeetask.dto.task.TaskDTO;
import bimaputra.employeetask.entity.Employee;
import bimaputra.employeetask.entity.Task;
import bimaputra.employeetask.repository.EmployeeRepository;
import bimaputra.employeetask.repository.TaskRepository;
import bimaputra.employeetask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  private final EmployeeRepository employeeRepository;

  @Override
  public List<Task> getAllTask() {
    return taskRepository.findAll();
  }

  @Override
  public Task createTask(TaskDTO taskDTO) {
    return taskRepository.save(convertDTOToTask(taskDTO));
  }


  private Task convertDTOToTask(TaskDTO taskDTO) {
    Employee employee = employeeRepository
            .findById(taskDTO.getEmployeeId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return Task.builder()
            .title(taskDTO.getTitle())
            .description(taskDTO.getDescription())
            .status(taskDTO.getStatus())
            .employee(employee)
            .build();
  }

}
