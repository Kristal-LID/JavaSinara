package com.urfu.homework.database;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TodoListDTO {
    private String name;
    private List<String> events;
}