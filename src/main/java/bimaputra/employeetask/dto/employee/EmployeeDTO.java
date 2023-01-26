package bimaputra.employeetask.dto.employee;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class EmployeeDTO {

  @Size(max = 255, message = "name can not greater than 255 characters")
  @NotNull(message = "name can not null")
  private String name;

}
