package com.hexagonal.tasks.infrastructure.adapters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonPlaceHolderTodo {

    private Long id;
    private Long userId;

}
