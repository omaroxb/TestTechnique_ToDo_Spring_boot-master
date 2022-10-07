package com.test.testtechnique_todo_spring_boot.service.implementation;

import com.test.testtechnique_todo_spring_boot.enumeration.Behavior;
import com.test.testtechnique_todo_spring_boot.enumeration.UserState;
import com.test.testtechnique_todo_spring_boot.exception.exceptionclass.ObjectNotFound;
import com.test.testtechnique_todo_spring_boot.model.Task;
import com.test.testtechnique_todo_spring_boot.model.User;
import com.test.testtechnique_todo_spring_boot.repository.UserRepository;
import com.test.testtechnique_todo_spring_boot.service.UserService;
import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImp implements UserService {


    private  final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseMessage> createUser(User user) {
        userRepository.save(user);
        ResponseMessage responseMessage = new ResponseMessage("User added.", Behavior.SUCCESS);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
   }
    @Override
    public ResponseEntity<ResponseMessage> changeStateUser(UserState userState, Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("User not found");
                    throw new ObjectNotFound("User not found.");
                });
        log.info("User found.");
       foundUser.setState(userState);
       userRepository.save(foundUser);
       log.info("User state updated.");
       ResponseMessage responseMessage = new ResponseMessage("State updated", Behavior.SUCCESS);
       return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseMessage> updateUser(User user, Long id) {
        User founduser = userRepository.findById(id)
                .orElseThrow(() ->{
                    log.error("user not found");
                    throw new ObjectNotFound("user not found");
                });
        log.info("user found");
        founduser.updateUser(user);
        userRepository.save(user);
        log.info("User state updated.");
        ResponseMessage responseMessage = new ResponseMessage("user updated", Behavior.SUCCESS);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);


    }

    @Override
    public List<User> getAll() {
        List<User> allures = userRepository.findAll();


        return allures;
    }

    @Override
    public ResponseEntity<ResponseMessage> getAllWithTasks() {
        return null;
    }
}
