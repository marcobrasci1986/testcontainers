package be.avidoo.testcontainers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @SequenceGenerator(name = "sequence_generator_department", sequenceName = "seq_department_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator_department")
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column
    private String category;

    @Column
    private Long capacity;


}
