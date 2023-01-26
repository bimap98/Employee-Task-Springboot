package bimaputra.employeetask.entity;

import bimaputra.employeetask.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;

  @Column(name = "title", columnDefinition = "VARCHAR(255)", nullable = false)
  private String title;

  @Column(name = "description", columnDefinition = "TEXT", nullable = false)
  private String description;

  @Enumerated(EnumType.STRING)
  private TaskStatus status;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonIgnore
  private Employee employee;

}
