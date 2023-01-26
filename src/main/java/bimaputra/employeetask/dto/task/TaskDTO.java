package bimaputra.employeetask.dto.task;

import bimaputra.employeetask.enums.TaskStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskDTO {

  @Size(max = 255, message = "title can not greater than 255 characters")
  @NotNull(message = "title can not null")
  private String title;

  @NotNull(message = "description can not null")
  private String description;

  @NotNull(message = "Task status can not null")
  private TaskStatus status;

  @Positive(message = "Employee id is invalid")
  private long employeeId;

}
