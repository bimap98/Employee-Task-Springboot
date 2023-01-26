package bimaputra.employeetask.service;

import bimaputra.employeetask.dto.task.TaskDTO;
import bimaputra.employeetask.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {

  List<Task> getAllTask();

  Task createTask(TaskDTO taskDTO);



}
