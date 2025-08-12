package com.hexagonal.tasks.infrastructure.adapters.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonPlaceHolderUser {

    private Long id;
    private String name;
    private String email;

}
