package com.test.testtechnique_todo_spring_boot.util.utilclass;

import com.test.testtechnique_todo_spring_boot.enumeration.Behavior;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    private String message;
    private Behavior behavior;
}
