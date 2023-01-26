package bimaputra.employeetask.repository;

import bimaputra.employeetask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}
