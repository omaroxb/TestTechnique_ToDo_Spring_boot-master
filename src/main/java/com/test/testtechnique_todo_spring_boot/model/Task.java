package com.test.testtechnique_todo_spring_boot.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name= "t_task")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String description;
    @ManyToOne(
    )
    @JoinColumn(
            name= "user_id", referencedColumnName = "id",
            nullable = false, foreignKey = @ForeignKey(name = "user_fk")
    )
    private User user = new User();
}
