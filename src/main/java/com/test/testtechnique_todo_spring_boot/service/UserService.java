package com.test.testtechnique_todo_spring_boot.service;

import com.test.testtechnique_todo_spring_boot.enumeration.UserState;
import com.test.testtechnique_todo_spring_boot.model.User;
import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<ResponseMessage> createUser(User user);
    public ResponseEntity<ResponseMessage> changeStateUser(UserState userState, Long id);
    public ResponseEntity<ResponseMessage> updateUser(User user, Long id);
    public List<User> getAll();
    public ResponseEntity<ResponseMessage> getAllWithTasks();
}
