package com.test.testtechnique_todo_spring_boot.repository;

import com.test.testtechnique_todo_spring_boot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
