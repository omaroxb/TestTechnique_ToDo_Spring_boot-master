package com.test.testtechnique_todo_spring_boot.model;

import com.test.testtechnique_todo_spring_boot.enumeration.UserState;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "t_user")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, length = 50 )
    private String name;
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserState state = UserState.ACTIVE;
    @OneToMany(mappedBy = "user")
    private Set<Task> tasks= new HashSet<Task>();



    public void updateUser (User user){
        this.name = user.getName();
        this.password = user.getPassword();
    }
}