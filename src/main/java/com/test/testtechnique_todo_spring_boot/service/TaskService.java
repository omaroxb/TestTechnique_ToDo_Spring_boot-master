package com.test.testtechnique_todo_spring_boot.service;

import com.test.testtechnique_todo_spring_boot.enumeration.UserState;
import com.test.testtechnique_todo_spring_boot.model.Task;

import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {



    public ResponseEntity<ResponseMessage> createTask(Task task);
    public ResponseEntity<ResponseMessage> UpdateTask(Task task, Long id);
    public ResponseEntity<ResponseMessage> DeleteTask(Task task, Long id);
    public List<Task> getAll();

}
