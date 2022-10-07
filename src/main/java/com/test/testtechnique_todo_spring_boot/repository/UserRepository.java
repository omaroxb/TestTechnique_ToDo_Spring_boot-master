package com.test.testtechnique_todo_spring_boot.repository;

import com.test.testtechnique_todo_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
