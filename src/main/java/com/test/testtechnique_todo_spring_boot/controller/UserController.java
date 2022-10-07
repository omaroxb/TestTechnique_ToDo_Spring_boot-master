package com.test.testtechnique_todo_spring_boot.controller;
import com.test.testtechnique_todo_spring_boot.model.User;
import com.test.testtechnique_todo_spring_boot.service.implementation.UserServiceImp;
import com.test.testtechnique_todo_spring_boot.util.utilclass.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImp userServiceImp;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        log.info("fffff");
        return new ResponseEntity<List<User>>(userServiceImp.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addUser (@RequestBody User user){
        return new ResponseEntity (userServiceImp.createUser(user), HttpStatus.CREATED);

    }





}
