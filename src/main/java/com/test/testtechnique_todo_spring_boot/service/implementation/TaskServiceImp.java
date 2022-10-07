package com.test.testtechnique_todo_spring_boot.service.implementation;

import com.test.testtechnique_todo_spring_boot.enumeration.Behavior;
import com.test.testtechnique_todo_spring_boot.exception.exceptionclass.ObjectNotFound;
import com.test.testtechnique_todo_spring_boot.model.Task;
import com.test.testtechnique_todo_spring_boot.repository.TaskRepository;

import com.test.testtechnique_todo_spring_boot.service.TaskService;
import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImp implements TaskService {
    private TaskRepository taskRepository;
    @Override
    public ResponseEntity<ResponseMessage> createTask(Task task) {

        taskRepository.save(task);
        ResponseMessage responseMessage = new ResponseMessage("task added.", Behavior.SUCCESS);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResponseMessage> UpdateTask(Task task,Long id) {
        Task foundTask = taskRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Task not found");
                    throw new ObjectNotFound("Task not found.");
                });
        log.info("Task found.");
        foundTask.setDescription(task.getDescription());
        taskRepository.save(foundTask);
        log.info("Task  updated.");
        ResponseMessage responseMessage = new ResponseMessage("Task updated", Behavior.SUCCESS);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseMessage> DeleteTask(Task task, Long id) {
        Task foundTask = taskRepository.findById(id).
                orElseThrow(() -> {
                    throw new ObjectNotFound("task not found");
                });
        taskRepository.delete(foundTask);
        ResponseMessage responseMessage = new ResponseMessage("Task delete", Behavior.SUCCESS);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

    }

    @Override
    public List<Task> getAll() {
        List<Task> alltask = taskRepository.findAll();
        log.info("All Task.");
        return alltask;
    }
}
