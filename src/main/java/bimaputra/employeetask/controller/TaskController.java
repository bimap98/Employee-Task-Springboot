package bimaputra.employeetask.controller;

import bimaputra.employeetask.dto.task.TaskDTO;
import bimaputra.employeetask.entity.Task;
import bimaputra.employeetask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("/")
  public List<Task> getAllTask() {
    return taskService.getAllTask();
  }

  @PostMapping
  public Task createTask(@RequestBody TaskDTO taskDTO) {
    return taskService.createTask(taskDTO);
  }



}
